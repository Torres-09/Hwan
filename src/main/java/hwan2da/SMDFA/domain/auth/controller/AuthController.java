package hwan2da.SMDFA.domain.auth.controller;

import hwan2da.SMDFA.domain.auth.model.dto.SignUpRequest;
import hwan2da.SMDFA.domain.auth.model.dto.SignUpResponse;
import hwan2da.SMDFA.domain.auth.service.AuthService;
import hwan2da.SMDFA.domain.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * TODO: 소셜 로그인 기능 추가
     * 소셜 로그인 API 추가
     * - AuthController
     */
}
