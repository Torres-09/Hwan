package hwan2da.SMDFA.config.provider;

import hwan2da.SMDFA.config.client.naver.NaverAuthApiClient;
import hwan2da.SMDFA.config.client.naver.dto.NaverProfileResponse;
import hwan2da.SMDFA.domain.auth.model.dto.SocialResponse;
import hwan2da.SMDFA.util.HttpHeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NaverAuthProvider implements AuthProvider{

    private final NaverAuthApiClient naverAuthApiClient;
    

    @Override
    public SocialResponse getSocialResponse(String token) {
        NaverProfileResponse response = naverAuthApiClient.getProfileInfo(HttpHeaderUtils.withBearerToken(token));
        
        // 수정 필요 - 네이버에 맞춰서
        return null;
    }
}
