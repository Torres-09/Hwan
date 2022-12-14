package hwan2da.SMDFA.domain.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static hwan2da.SMDFA.domain.member.model.QMember.*;

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
