package hwan.demo.config.interceptor;

import hwan.demo.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Login login = handlerMethod.getMethodAnnotation(Login.class);
        if (login == null) {
            return true;
        }

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        boolean isValidate = jwtProvider.validateToken(token);
        request.setAttribute(HttpHeaders.AUTHORIZATION, token);
        return isValidate;
    }
}
