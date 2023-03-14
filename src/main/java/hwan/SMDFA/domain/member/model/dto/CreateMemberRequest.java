package hwan.SMDFA.domain.member.model.dto;

import hwan.SMDFA.domain.member.model.Member;
import hwan.SMDFA.domain.member.model.MemberSocialType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMemberRequest {
    private String socialId;
    @NotBlank
    private String socialEmail;

    @NotNull
    private MemberSocialType socialType;

    // 닉네임 조건 체크 어노테이션 이후 추가
    private String nickname;

    @Builder
    private CreateMemberRequest(String socialId, String socialEmail, MemberSocialType socialType, String nickname) {
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        this.socialType = socialType;
        this.nickname = nickname;
    }

    public Member toEntity() {
        return Member.newMember(socialId, socialEmail, socialType, nickname);
    }
}
