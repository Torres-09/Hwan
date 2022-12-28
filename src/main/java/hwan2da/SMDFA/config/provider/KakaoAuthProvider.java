package hwan2da.SMDFA.config.provider;

import hwan2da.SMDFA.config.client.kakao.KakaoAuthApiClient;
import hwan2da.SMDFA.config.client.kakao.dto.KakaoProfileResponse;
import hwan2da.SMDFA.config.client.naver.NaverAuthApiClient;
import hwan2da.SMDFA.config.client.naver.dto.NaverProfileResponse;
import hwan2da.SMDFA.util.HttpHeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KakaoAuthProvider implements AuthProvider{

    private final KakaoAuthApiClient kakaoAuthApiClient;

    @Override
    public String getSocialEmail(String token) {
        KakaoProfileResponse response = kakaoAuthApiClient.getProfileInfo(HttpHeaderUtils.withBearerToken(token));
        return response.getKakao_account().getEmail();
    }
}
