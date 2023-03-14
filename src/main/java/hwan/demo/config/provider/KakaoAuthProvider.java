package hwan.demo.config.provider;

import hwan.demo.config.client.kakao.KakaoAuthApiClient;
import hwan.demo.config.client.kakao.dto.KakaoProfileResponse;
import hwan.demo.domain.auth.model.dto.SocialResponse;
import hwan.demo.util.HttpHeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KakaoAuthProvider implements AuthProvider{

    private final KakaoAuthApiClient kakaoAuthApiClient;

    @Override
    public SocialResponse getSocialResponse(String token) {
        KakaoProfileResponse response = kakaoAuthApiClient.getProfileInfo(HttpHeaderUtils.withBearerToken(token));
        SocialResponse socialResponse = SocialResponse.of(response.getId(), response.getKakao_account().getEmail());
        return socialResponse;
    }
}
