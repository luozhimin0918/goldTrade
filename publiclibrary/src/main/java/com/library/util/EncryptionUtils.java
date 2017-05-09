package com.library.util;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 项目名:Kxt
 * 类描述:接口加密解密
 * 创建人:苟蒙蒙
 * 创建日期:2017/4/17.
 */

public class EncryptionUtils {
    /**
     * 创建 jwt
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public static String createJWT(String key, String value) throws Exception {

        String jwtString = Jwts.builder()
                .setSubject(value)
                .signWith(SignatureAlgorithm.HS256, getJwtKey(key))
                .compact();
        return jwtString;
    }

    /**
     * 解密 jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt, String key) throws Exception {

        Claims claims = Jwts.parser()
                .setSigningKey(getJwtKey(key))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 解密 jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static void parseToString(String jwt, String key, ObserverToJson mObserverToJson) {

        ParseClaims jwtParser = new ParseClaims();
        jwtParser.setObserverToJson(mObserverToJson);
        jwtParser.setSigningKey(getJwtKey(key))
                .parseClaimsJws(jwt).getBody();

    }

    /**
     * 获取 jwt  key
     *
     * @param keyValue
     * @return
     */
    public static Key getJwtKey(String keyValue) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = keyValue.getBytes();
        Key key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return key;
    }

}
