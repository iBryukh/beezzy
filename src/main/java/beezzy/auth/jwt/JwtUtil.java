package beezzy.auth.jwt;

import beezzy.auth.jwt.domain.User;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.enums.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by oleh on 06.04.2016.
 */
@Component
public class JwtUtil {

    private String secret = "beezzy";


    public User parse(String token){
        if(token == null)
            return null;
        try {
            Claims body = Jwts
                    .parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            User user = new User();
            user.setId(Integer.valueOf(body.get(ID).toString()));
            user.setEmail(body.get(EMAIL).toString());
            user.setRole(Roles.valueOf(body.get(ROLE).toString()));

            return user;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String generate(UserEntity user){
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put(ID, user.getId()+"");
        claims.put(EMAIL, user.getEmail());
        claims.put(ROLE, user.getRole().getName());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String ROLE = "role";

    public static final String ACCESS_TOKEN = "access_token";
}
