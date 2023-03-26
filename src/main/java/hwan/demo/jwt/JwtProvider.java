package hwan.demo.jwt;

import hwan.demo.domain.common.exception.ErrorCode;
import hwan.demo.domain.common.exception.InvalidJwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {
    private final SecretKey secretKey;
    private final JwtProperties jwtProperties;

    private final JwtParser jwtParser;

    public JwtProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        byte[] bytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        this.secretKey = Keys.hmacShaKeyFor(bytes);
        this.jwtParser = Jwts.parserBuilder().requireIssuer(jwtProperties.getIssuer()).setSigningKey(secretKey).build();
    }

    public String generateAccessToken(Long memberId) {
        return issueToken(memberId, jwtProperties.getExpireTime());
    }

    public String issueToken(Long memberId, Long expireTime) {
        Date expiration = new Date(System.currentTimeMillis() + expireTime);

        return Jwts.builder().setAudience(String.valueOf(memberId)).setIssuer(jwtProperties.getIssuer()).setExpiration(expiration).signWith(secretKey).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = jwtParser.parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (SecurityException | MalformedJwtException | IllegalArgumentException | UnsupportedJwtException |
                 ExpiredJwtException e) {
            throw new InvalidJwtException(e.getMessage(), ErrorCode.E400_INVALID_AUTH_TOKEN);
        }
    }

    public String getAudience(String token) {
        return jwtParser.parseClaimsJws(token).getBody().getAudience();
    }
}
