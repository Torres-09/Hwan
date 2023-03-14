package hwan.demo.domain.auth.service;

import hwan.demo.config.provider.AuthProvider;
import hwan.demo.domain.member.model.MemberSocialType;

public interface AuthProviderFinder {
    /**
     * 소셜 타입에 따른 Provider를 연결해주는 메소드
     * @param socialType
     * @return
     */
    AuthProvider findAuthProvider(MemberSocialType socialType);
}
