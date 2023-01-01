package hwan2da.SMDFA.config.provider;

import hwan2da.SMDFA.domain.auth.model.dto.SocialResponse;

import java.util.List;

public interface AuthProvider {
    SocialResponse getSocialResponse(String token);
}
