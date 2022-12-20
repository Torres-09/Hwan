package hwan2da.SMDFA.config.client.naver.dto;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NaverProfileResponse {
    private String email;
}
