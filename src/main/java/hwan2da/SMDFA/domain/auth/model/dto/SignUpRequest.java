package hwan2da.SMDFA.domain.auth.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import hwan2da.SMDFA.domain.member.model.MemberSocialType;
import hwan2da.SMDFA.domain.member.model.dto.CreateMemberRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignUpRequest {

    private String token;

    private String nickname;

    private MemberSocialType socialType;

    public CreateMemberRequest toCreateMemberRequest(String socialEmail) {
        return CreateMemberRequest.builder()
                .socialEmail(socialEmail)
                .socialType(socialType)
                .nickname(nickname)
                .build();
    }
}
