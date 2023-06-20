package com.example.controller.interceptor;

import com.example.controller.exception.TokenAuthExpiredException;
import com.example.domain.User;
import com.example.util.SessionUtil;
import com.example.util.TokenUtil;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;
    @Value("${token.privateKey}")
    private String privateKey;
    @Value("${token.yangToken}")
    private Long yangToken;
    @Value("${token.oldToken}")
    private Long oldToken;
    /**
     * 权限认证的拦截操作.
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        //为空就返回错误
        String token = httpServletRequest.getHeader("token");
        if (null == token || "".equals(token.trim())) {
            return false;
        }
        Map<String, String> map = tokenUtil.parseToken(token);
        String userid = map.get("userid");
        String username = map.get("username");
        String password = map.get("password");
        String email = map.get("email");
        String is_admin = map.get("is_admin");
        long timeOfUse = System.currentTimeMillis() - Long.parseLong(map.get("timeStamp"));
        //1.判断 token 是否过期
        //年轻 token
        if (timeOfUse < yangToken) {
            System.out.println("年轻 token");
        }
        //老年 token 就刷新 token
        else if (timeOfUse >= yangToken && timeOfUse < oldToken) {
            httpServletResponse.setHeader("token",tokenUtil.getToken(userid, username,password,email,is_admin));
        }
        //过期 token 就返回 token 无效.
        else{
            new TokenAuthExpiredException();
        }
        return true;
    }
}
