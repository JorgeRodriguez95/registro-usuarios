package com.example.userregistration.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Config {

    @Value("#{'${jwt-millis}'}")
    private Integer millis;

    @Value("#{'${jwt-secret}'}")
    private String secretKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String getJWTToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + millis);

        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validate(String token){
        Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return true;
    }
}
