package hwan2da.SMDFA.domain.auth.service;


import hwan2da.SMDFA.domain.auth.model.dto.SignUpRequest;

public interface AuthService {
    Long signUp(SignUpRequest request);
}
