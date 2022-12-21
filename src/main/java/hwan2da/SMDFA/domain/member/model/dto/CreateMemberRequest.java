package hwan2da.SMDFA.domain.member.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import hwan2da.SMDFA.domain.member.model.Member;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateMemberRequest {
    @NotBlank
    private String socialEmail;

    @NotNull
    private MemberSocialType socialType;

    // 닉네임 조건 체크 어노테이션 이후 추가
    private String nickname;

    @Builder
    private CreateMemberRequest(String socialEmail, MemberSocialType socialType, String nickname) {
        this.socialEmail = socialEmail;
        this.socialType = socialType;
        this.nickname = nickname;
    }

    public Member toEntity() {
        return Member.newMember(socialEmail, socialType, nickname);
    }
}
