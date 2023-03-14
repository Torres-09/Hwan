package hwan.demo.domain.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static hwan.demo.domain.member.model.QMember.member;


@RequiredArgsConstructor
public class MemberBatchRepositoryCustomImpl implements MemberBatchRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public long countMember() {
        return queryFactory
                .selectFrom(member)
                .fetch()
                .size();
    }
}
