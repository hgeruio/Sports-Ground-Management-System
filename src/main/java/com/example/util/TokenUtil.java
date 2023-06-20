package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {
    @Value("${token.privateKey}")
    private String privateKey;

    /**
     * 加密token.
     */
    public String getToken(String userid, String username,String password,String email,String is_admin) {
        System.out.println(username);
        //这个是放到负载payLoad 里面,魔法值可以使用常量类进行封装.
        String token = JWT
                .create()
                .withClaim("userid" ,userid)
                .withClaim("username", username)
                .withClaim("password", password)
                .withClaim("email", email)
                .withClaim("is_admin", is_admin)
                .withClaim("timeStamp", System.currentTimeMillis())
                .sign(Algorithm.HMAC256(privateKey));
        return token;
    }

    /**
     * 解析token.
     * (优化可以用常量固定魔法值+使用DTO在 mvc 之前传输数据，而不是 map,这里因为篇幅原因就不做了)
     * {
     * "userId": "3412435312",
     * "userRole": "ROLE_USER",
     * "timeStamp": "134143214"
     * }
     */
    public Map<String, String> parseToken(String token) {
        HashMap<String, String> map = new HashMap<>();
        DecodedJWT decodedjwt = JWT.require(Algorithm.HMAC256(privateKey))
                .build().verify(token);
        Claim userid=decodedjwt.getClaim("userid");
        Claim username = decodedjwt.getClaim("username");
        Claim password = decodedjwt.getClaim("password");
        Claim email = decodedjwt.getClaim("email");
        Claim is_admin = decodedjwt.getClaim("is_admin");
        Claim timeStamp = decodedjwt.getClaim("timeStamp");
        map.put("userid", userid.asString());
        map.put("username", username.asString());
        map.put("password", password.asString());
        map.put("email", email.asString());
        map.put("is_admin", is_admin.asString());
        map.put("timeStamp", timeStamp.asLong().toString());
        return map;
    }
}
