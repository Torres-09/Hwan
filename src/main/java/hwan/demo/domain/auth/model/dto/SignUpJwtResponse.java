package hwan.demo.domain.auth.model.dto;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpJwtResponse {
    private String token;

    public static SignUpJwtResponse of(String token) {
        return new SignUpJwtResponse(token);
    }
}
