package hwan.SMDFA.domain.member.repository;

import hwan.SMDFA.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>,MemberBatchRepositoryCustom, MemberRepositoryCustom {
}
