package hwan.SMDFA.domain.member.repository;

import hwan.SMDFA.domain.member.model.Member;
import hwan.SMDFA.domain.member.model.MemberSocialType;


public interface MemberRepositoryCustom {
    boolean existMemberBySocialInfo(String socialId, MemberSocialType socialType);

    Member findUserBySocial(String socialId, MemberSocialType type);
}
