package hwan.demo.config.client.naver;

import hwan.demo.config.client.naver.dto.NaverProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class NaverAuthApiClient {
    private final WebClient webClient;

    @Transactional
    public NaverProfileResponse getProfileInfo(@RequestHeader("Authorization") String accessToken) {
        return webClient.get()
                .uri("https://openapi.naver.com/v1/nid/me")
                .headers(httpHeaders -> {
                    httpHeaders.setBearerAuth(accessToken);
                })
                .retrieve()
                .bodyToFlux(NaverProfileResponse.class)
                .blockFirst();
    }
}
