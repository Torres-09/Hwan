package hwan.demo.domain.auth.controller;

import hwan.demo.config.interceptor.Auth;
import hwan.demo.config.interceptor.Login;
import hwan.demo.config.resolver.MemberId;
import hwan.demo.domain.auth.model.dto.*;
import hwan.demo.domain.auth.service.AuthService;
import hwan.demo.domain.common.dto.ApiResponse;
import hwan.demo.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static hwan.demo.config.session.SessionConstant.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final HttpSession httpSession;
    private final AuthService authService;
    private final JwtProvider jwtProvider;

    @PostMapping("/v1/signup")
    public ApiResponse<SignUpResponse> signUp(
            @Valid @RequestBody SignUpRequest request
            ) {
        Long memberId = authService.signUp(request);
        httpSession.setAttribute(MEMBER_ID, memberId);

        SignUpResponse response = SignUpResponse.of(httpSession.getId(), memberId);
        return ApiResponse.success(response);
    }

    @PostMapping("/v1/signup/jwt")
    public ApiResponse<SignUpJwtResponse> signUpJwt(
            @Valid @RequestBody SignUpRequest request
    ) {
        Long memberId = authService.signUp(request);
        return ApiResponse.success(SignUpJwtResponse.of(jwtProvider.generateAccessToken(memberId)));
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {
        Long memberId = authService.login(request);
        httpSession.setAttribute(MEMBER_ID, memberId);

        LoginResponse response = LoginResponse.of(httpSession.getId(), memberId);
        return ApiResponse.success(response);
    }

    @Auth
    @PostMapping("/logout")
    public ApiResponse<String> logout(
            @Valid @MemberId Long memberId
    ) {
        httpSession.invalidate();
        return ApiResponse.success("로그아웃이 되었습니다.");
    }

    @GetMapping("/test")
    public ApiResponse<String> test(
    ) {
        return ApiResponse.success("테스트입니다.");
    }
}
