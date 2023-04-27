package hwan.demo.config.provider;

import hwan.demo.config.client.github.GithubAuthApiClient;
import hwan.demo.config.client.github.dto.GithubProfileResponse;
import hwan.demo.domain.auth.model.dto.SocialResponse;
import hwan.demo.util.HttpHeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GithubAuthProvider implements AuthProvider {
    private final GithubAuthApiClient githubAuthApiClient;

    @Override
    public SocialResponse getSocialResponse(String token) {
        GithubProfileResponse response = githubAuthApiClient.getProfileInfo(HttpHeaderUtils.withBearerToken(token));
        SocialResponse socialResponse = SocialResponse.of(response.getId(), response.getEmail());
        return socialResponse;
    }
}
