package hwan.SMDFA.domain.auth.service;

import hwan.SMDFA.config.provider.AuthProvider;
import hwan.SMDFA.domain.member.model.MemberSocialType;

public interface AuthProviderFinder {
    /**
     * 소셜 타입에 따른 Provider를 연결해주는 메소드
     * @param socialType
     * @return
     */
    AuthProvider findAuthProvider(MemberSocialType socialType);
}
