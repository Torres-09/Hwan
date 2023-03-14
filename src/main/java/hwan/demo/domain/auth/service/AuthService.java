package hwan.demo.domain.auth.service;


import hwan.demo.domain.auth.model.dto.LoginRequest;
import hwan.demo.domain.auth.model.dto.SignUpRequest;

public interface AuthService {
    Long signUp(SignUpRequest request);

    Long login(LoginRequest request);
}
