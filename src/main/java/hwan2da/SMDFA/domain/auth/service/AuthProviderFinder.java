package hwan2da.SMDFA.domain.auth.service;

import hwan2da.SMDFA.config.provider.AuthProvider;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;

public interface AuthProviderFinder {
    /**
     * 소셜 타입에 따른 Provider를 연결해주는 메소드
     * @param socialType
     * @return
     */
    AuthProvider findAuthProvider(MemberSocialType socialType);
}
