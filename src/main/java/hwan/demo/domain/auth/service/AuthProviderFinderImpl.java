package hwan.demo.domain.auth.service;

import hwan.demo.config.provider.*;
import hwan.demo.domain.member.model.MemberSocialType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class AuthProviderFinderImpl implements AuthProviderFinder{
    private static final Map<MemberSocialType, AuthProvider> authProviderMap = new EnumMap<>(MemberSocialType.class);

    private final NaverAuthProvider naverAuthProvider;
    private final KakaoAuthProvider kakaoAuthProvider;
    private final GithubAuthProvider githubAuthProvider;
    private final GoogleAuthProvider googleAuthProvider;

    @PostConstruct
    void initializeAuthProviders() {
        authProviderMap.put(MemberSocialType.NAVER, naverAuthProvider);
        authProviderMap.put(MemberSocialType.KAKAO, kakaoAuthProvider);
        authProviderMap.put(MemberSocialType.GITHUB, githubAuthProvider);
        authProviderMap.put(MemberSocialType.GOOGLE, googleAuthProvider);
    }

    @Override
    public AuthProvider findAuthProvider(MemberSocialType socialType) {
        AuthProvider authProvider = authProviderMap.get(socialType);

        // 지원하지 않는 소셜타입에 대한 예외처리 적용
        
        return authProvider;
    }
}
