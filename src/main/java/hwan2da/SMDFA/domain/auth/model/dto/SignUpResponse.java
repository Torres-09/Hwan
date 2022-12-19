package hwan2da.SMDFA.domain.auth.model.dto;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpResponse {

    private String token;

    private Long memberId;

    public static SignUpResponse of(String sessionId, Long memberId) {
        return new SignUpResponse(sessionId, memberId);
    }

}
