package operator.service.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import operator.service.model.ApiClient;
import org.springframework.stereotype.Component;

import java.util.Date;

import static operator.service.security.SecurityConstants.EXPIRATION_TIME;
import static operator.service.security.SecurityConstants.SECRET;

@Component
public class JwtUtil {

    public String createToken(ApiClient apiClient){

        String token = JWT.create()
                .withClaim("client_id",apiClient.getId())
                .withSubject(apiClient.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        return token;
    }

}
