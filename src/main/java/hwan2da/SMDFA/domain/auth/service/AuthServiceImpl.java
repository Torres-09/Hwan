package hwan2da.SMDFA.domain.auth.service;

import hwan2da.SMDFA.config.provider.AuthProvider;
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
    private final AuthProviderFinder authProviderFinder;


    public Long signUp(SignUpRequest request) {
        AuthProvider authProvider = authProviderFinder.findAuthProvider(request.getSocialType());
        String socialEmail = authProvider.getSocialEmail(request.getToken());
        return memberService.registerMember(request.toCreateMemberRequest(socialEmail));
    }
}
