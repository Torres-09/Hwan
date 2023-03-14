package hwan.SMDFA.domain.member.service;

import hwan.SMDFA.domain.member.model.Member;
import hwan.SMDFA.domain.member.model.dto.CreateMemberRequest;
import hwan.SMDFA.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Transactional
    public Long registerMember(CreateMemberRequest request) {
        if (memberRepository.existMemberBySocialInfo(request.getSocialId(), request.getSocialType())) {
            // 회원이 존재하는 경우 실패 로직 추가해야 함
            throw null;
        }
        Member member = memberRepository.save(request.toEntity());
        return member.getId();
    }
}
