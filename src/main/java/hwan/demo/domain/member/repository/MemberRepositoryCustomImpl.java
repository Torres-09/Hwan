package hwan.demo.domain.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hwan.demo.domain.member.model.Member;
import hwan.demo.domain.member.model.MemberSocialType;
import lombok.RequiredArgsConstructor;

import static hwan.demo.domain.member.model.QMember.member;


@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existMemberBySocialInfo(String socialId, MemberSocialType socialType) {
        return queryFactory
                .selectOne()
                .from(member)
                .where(
                        member.memberSocialInfo.socialId.eq(socialId),
                        member.memberSocialInfo.socialType.eq(socialType)
                ).fetchFirst() != null;
    }

    @Override
    public Member findUserBySocial(String socialId, MemberSocialType type) {
        return queryFactory
                .selectFrom(member)
                .where(
                        member.memberSocialInfo.socialId.eq(socialId),
                        member.memberSocialInfo.socialType.eq(type)
                ).fetchOne();
    }
}
