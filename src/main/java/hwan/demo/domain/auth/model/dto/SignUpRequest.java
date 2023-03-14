package hwan.demo.domain.auth.model.dto;

import hwan.demo.domain.member.model.MemberSocialType;
import hwan.demo.domain.member.model.dto.CreateMemberRequest;
import lombok.*;


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpRequest {

    private String token;

    private String nickname;

    private MemberSocialType socialType;

    public CreateMemberRequest toCreateMemberRequest(String socialId, String socialEmail) {
        return CreateMemberRequest.builder()
                .socialId(socialId)
                .socialEmail(socialEmail)
                .socialType(socialType)
                .nickname(nickname)
                .build();
    }
}
