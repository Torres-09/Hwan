package hwan.SMDFA.config.provider;

import hwan.SMDFA.domain.auth.model.dto.SocialResponse;

public interface AuthProvider {
    SocialResponse getSocialResponse(String token);
}
