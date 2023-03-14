package hwan.demo.domain.member.repository;

import hwan.demo.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>,MemberBatchRepositoryCustom, MemberRepositoryCustom {
}
