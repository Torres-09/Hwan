package hwan2da.SMDFA.domain.auth.controller;

import hwan2da.SMDFA.config.interceptor.Auth;
import hwan2da.SMDFA.config.resolver.MemberId;
import hwan2da.SMDFA.domain.auth.model.dto.LoginRequest;
import hwan2da.SMDFA.domain.auth.model.dto.LoginResponse;
import hwan2da.SMDFA.domain.auth.model.dto.SignUpRequest;
import hwan2da.SMDFA.domain.auth.model.dto.SignUpResponse;
import hwan2da.SMDFA.domain.auth.service.AuthService;
import hwan2da.SMDFA.domain.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static hwan2da.SMDFA.config.session.SessionConstant.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final HttpSession httpSession;
    private final AuthService authService;

    @PostMapping("/v1/signup")
    public ApiResponse<SignUpResponse> signUp(
            @Valid @RequestBody SignUpRequest request
            ) {
        Long memberId = authService.signUp(request);
        httpSession.setAttribute(MEMBER_ID, memberId);

        SignUpResponse response = SignUpResponse.of(httpSession.getId(), memberId);
        return ApiResponse.success(response);
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
