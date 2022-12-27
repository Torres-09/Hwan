package hwan2da.SMDFA.config.client.kakao.dto;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KakaoProfileResponse {
    private String email;
}
