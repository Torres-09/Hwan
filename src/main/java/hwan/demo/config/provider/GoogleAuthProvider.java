package hwan.demo.config.provider;

import hwan.demo.config.client.github.GithubAuthApiClient;
import hwan.demo.config.client.github.dto.GithubProfileResponse;
import hwan.demo.config.client.google.GoogleAuthApiClient;
import hwan.demo.config.client.google.dto.GoogleProfileResponse;
import hwan.demo.domain.auth.model.dto.SocialResponse;
import hwan.demo.util.HttpHeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GoogleAuthProvider implements AuthProvider {
    private final GoogleAuthApiClient googleAuthApiClient;

    @Override
    public SocialResponse getSocialResponse(String token) {
        GoogleProfileResponse response = googleAuthApiClient.getProfileInfo(HttpHeaderUtils.withBearerToken(token));
        SocialResponse socialResponse = SocialResponse.of(response.getSub(), response.getEmail());
        return socialResponse;
    }
}
