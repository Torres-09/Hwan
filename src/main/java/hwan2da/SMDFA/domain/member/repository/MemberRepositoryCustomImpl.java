package hwan2da.SMDFA.domain.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;
import hwan2da.SMDFA.domain.member.model.QMember;
import lombok.RequiredArgsConstructor;

import static hwan2da.SMDFA.domain.member.model.QMember.*;


@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existMemberBySocialInfo(String socialEmail, MemberSocialType socialType) {
        return queryFactory
                .selectOne()
                .from(member)
                .where(
                        member.memberSocialInfo.socialEmail.eq(socialEmail),
                        member.memberSocialInfo.socialType.eq(socialType)
                ).fetchFirst() != null;
    }
}
