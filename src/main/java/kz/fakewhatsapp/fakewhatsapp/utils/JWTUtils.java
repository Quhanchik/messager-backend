package kz.fakewhatsapp.fakewhatsapp.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {
    private String jwtSecret = "ASFASfaSFASf8ASf98AS5as16f1as6f16asf116151asf56516asf6561a6s1f6a8s1f86as1f8a6s1f161as68f";

    private int jwtExpirationMs = 604800000 / 7;

    public String generateJwtToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Claims getAllClaims(String token) {
        return  Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromJwtToken(String token) {
        return getAllClaims(token).getSubject();
    }

    public Date getExpirationTime(String token) {
        return getAllClaims(token).getExpiration();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
