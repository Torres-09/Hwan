package hwan.demo.config.client.github;

import hwan.demo.config.client.github.dto.GithubProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class GithubAuthApiClient {
    private final WebClient webClient;

    @Transactional
    public GithubProfileResponse getProfileInfo(String accessToken) {
        return webClient.get()
                .uri("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .retrieve()
                .bodyToFlux(GithubProfileResponse.class)
                .blockFirst();
    }
}
