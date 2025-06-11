package org.fj.minhaapi.utils;

import io.jsonwebtoken.*;
import org.fj.minhaapi.model.Usuario;

import java.util.Date;

public class TokenUtil {

    private static final long EXPIRATION_MS = 1000 * 60 * 60; // 1 hora

    private static final String SECRET = "U7kp!a39d@pO28mQxLvbKz!2fhs93KdL";

    public static String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getLogin())
                .claim("perfil", usuario.getPerfil())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }

    public static String validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token);
            return claims.getBody().getSubject();
        } catch (JwtException e) {
            return null;
        }
    }
}
