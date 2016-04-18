package beezzy.auth.aop;

import beezzy.auth.jwt.JwtUtil;
import beezzy.auth.jwt.domain.User;
import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.enums.Permissions;
import beezzy.domain.enums.Roles;
import beezzy.exceptions.ForbiddenException;
import beezzy.exceptions.UnauthorizedException;
import beezzy.utils.SessionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by oleh on 06.04.2016.
 */
@Aspect
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
public class AuthAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SessionUtils sessionUtils;

    @Autowired
    private JwtUtil jwtUtil;

    @Before("execution(* beezzy.controller..*(..)) && @annotation(beezzy.auth.aop.Auth) && @annotation(auth)")
    private void before(Auth auth) throws UnauthorizedException, ForbiddenException {
        String token = request.getParameter(JwtUtil.ACCESS_TOKEN);
        User user = jwtUtil.parse(token);
        sessionUtils.setUser(user);

        if(auth.required()){
            if(user == null){
                throw new UnauthorizedException();
            }

            boolean hasRole = false;
            for(Roles r : auth.roles()){
                if(user.getRole() == r){
                    hasRole = true;
                    break;
                }
            }
            if(!hasRole)
                throw new ForbiddenException();
        }
    }

}
