package com.team1.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.team1.exception.AuthManagerException;
import com.team1.exception.ErrorType;
import com.team1.repository.enums.ERole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {


    String secretKey = "secretKey";
    String issuer = "issuer";

    public Optional<String> createToken(Long id){
        String token=null;
        Date date=new Date(System.currentTimeMillis()+(1000*60*5));
        try {
            token= JWT.create()
                    .withIssuer(issuer)
                    .withClaim("authId",id)
                    .withIssuedAt(new Date())
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC512(secretKey));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  Optional.ofNullable(token);
    }

    public Optional<String> createToken(Long id, ERole role){
        String token=null;
        Date date=new Date(System.currentTimeMillis()+(1000*60*5));
        try {
            token= JWT.create()
                    .withIssuer(issuer)
                    .withClaim("authId",id)
                    .withClaim("role",role.toString())
                    .withIssuedAt(new Date())
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC512(secretKey));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  Optional.ofNullable(token);
    }

    public Optional<Long> getIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null) {
                throw new AuthManagerException(ErrorType.INVALID_TOKEN);
            }
            Long id = decodedJWT.getClaim("authId").asLong();
            return Optional.of(id);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new AuthManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
