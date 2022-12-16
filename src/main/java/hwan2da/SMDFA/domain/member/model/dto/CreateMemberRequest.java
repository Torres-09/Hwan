package hwan2da.SMDFA.domain.member.model.dto;

import hwan2da.SMDFA.domain.member.model.Member;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMemberRequest {
    @NotBlank
    private String socialEmail;

    @NotNull
    private MemberSocialType socialType;

    // 닉네임 조건 체크 어노테이션 이후 추가
    private String nickname;

    public Member toEntity() {
        return Member.newMember(socialEmail, socialType, nickname);
    }
}
