package hwan2da.SMDFA.domain.auth.service;

import hwan2da.SMDFA.domain.auth.model.dto.SignUpRequest;
import hwan2da.SMDFA.domain.member.repository.MemberRepository;
import hwan2da.SMDFA.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public Long signUp(SignUpRequest request) {
        // request로 소셜 정보를 받아와서 Email을 추출해야한다.

        return memberService.registerMember(request.toCreateMemberRequest(null));
    }
}
