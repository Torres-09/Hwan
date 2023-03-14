package hwan.demo.config.provider;

import hwan.demo.domain.auth.model.dto.SocialResponse;

public interface AuthProvider {
    SocialResponse getSocialResponse(String token);
}
