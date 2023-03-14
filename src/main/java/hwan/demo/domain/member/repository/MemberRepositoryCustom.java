package hwan.demo.domain.member.repository;

import hwan.demo.domain.member.model.Member;
import hwan.demo.domain.member.model.MemberSocialType;


public interface MemberRepositoryCustom {
    boolean existMemberBySocialInfo(String socialId, MemberSocialType socialType);

    Member findUserBySocial(String socialId, MemberSocialType type);
}
