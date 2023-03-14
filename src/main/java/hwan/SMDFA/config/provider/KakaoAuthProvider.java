package hwan.SMDFA.config.provider;

import hwan.SMDFA.config.client.kakao.KakaoAuthApiClient;
import hwan.SMDFA.config.client.kakao.dto.KakaoProfileResponse;
import hwan.SMDFA.domain.auth.model.dto.SocialResponse;
import hwan.SMDFA.util.HttpHeaderUtils;
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
