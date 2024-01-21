package cc.william.bigevent.interceptors;

import cc.william.bigevent.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if(token == null){
            response.setStatus(401);
            return false;
        }

        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }

        return true;

    }

}
