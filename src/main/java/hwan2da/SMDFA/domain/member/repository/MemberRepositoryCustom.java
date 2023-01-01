package hwan2da.SMDFA.domain.member.repository;

import hwan2da.SMDFA.domain.member.model.Member;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;


public interface MemberRepositoryCustom {
    boolean existMemberBySocialInfo(String socialId, MemberSocialType socialType);

    Member findUserBySocial(String socialId, MemberSocialType type);
}
