package hwan.SMDFA.domain.auth.model.dto;


import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SocialResponse {
    private String socialId;
    private String socialEmail;

    public static SocialResponse of(String socialId, String socialEmail) {
        return new SocialResponse(socialId, socialEmail);
    }
}
