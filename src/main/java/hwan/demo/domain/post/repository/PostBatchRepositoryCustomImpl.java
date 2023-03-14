package hwan.demo.domain.post.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostBatchRepositoryCustomImpl implements PostBatchRepositoryCustom{
    private final JPAQueryFactory queryFactory;
}
