package hwan.SMDFA.domain.auth.service;


import hwan.SMDFA.domain.auth.model.dto.LoginRequest;
import hwan.SMDFA.domain.auth.model.dto.SignUpRequest;

public interface AuthService {
    Long signUp(SignUpRequest request);

    Long login(LoginRequest request);
}
