package hwan.demo.config.client.google;

import hwan.demo.config.client.google.dto.GoogleProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class GoogleAuthApiClient {
    private final WebClient webClient;

    @Transactional
    public GoogleProfileResponse getProfileInfo(String accessToken) {
        return webClient.get()
                .uri("https://www.googleapis.com/oauth2/v3/userinfo")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToFlux(GoogleProfileResponse.class)
                .blockFirst();
    }
}
