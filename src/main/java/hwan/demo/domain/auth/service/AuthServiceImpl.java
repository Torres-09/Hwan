package hwan.demo.domain.auth.service;

import hwan.demo.config.provider.AuthProvider;
import hwan.demo.domain.auth.model.dto.LoginRequest;
import hwan.demo.domain.auth.model.dto.SignUpRequest;
import hwan.demo.domain.auth.model.dto.SocialResponse;
import hwan.demo.domain.member.model.Member;
import hwan.demo.domain.member.model.MemberSocialType;
import hwan.demo.domain.member.repository.MemberRepository;
import hwan.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final AuthProviderFinder authProviderFinder;


        @Override
        public Long signUp(SignUpRequest request) {
            AuthProvider authProvider = authProviderFinder.findAuthProvider(request.getSocialType());
            SocialResponse socialResponse = authProvider.getSocialResponse(request.getToken());
            return memberService.registerMember(request.toCreateMemberRequest(socialResponse.getSocialId(), socialResponse.getSocialEmail()));
        }

        @Override
        public Long login(LoginRequest request) {
            AuthProvider authProvider = authProviderFinder.findAuthProvider(request.getSocialType());
            SocialResponse socialResponse = authProvider.getSocialResponse(request.getToken());
            return findMemberBySocialIdAndSocialType(socialResponse, request.getSocialType()).getId();
        }

        public Member findMemberBySocialIdAndSocialType(SocialResponse socialResponse, MemberSocialType type) {
            Member member = memberRepository.findUserBySocial(socialResponse.getSocialId(), type);
        if (member == null) {
            throw new IllegalArgumentException();
        }
        return member;
    }
}
