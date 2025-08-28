package com.projects.demo.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JWTService {
    @Value("${jwt.secret}")

    private String secretKey;

    // Use @PostConstruct to initialize the secretKey after the bean is created
//    @PostConstruct
//    public void init() {
//        this.secretKey = generateSecretKey();
//    }

    public String generateToken(String username) {

        Map<String,Object> claims = new HashMap<>();
        return
                Jwts.builder()
                        .setClaims(claims)
                        .setSubject(username)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis()+1000*60*3))
                        .signWith(getKey(), SignatureAlgorithm.HS256).compact();

    }




    private String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            // Explicitly set the key size to 256 bits
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Secret Key :" + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }


    @PostConstruct
    public void debugKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        System.out.println("🔑 Decoded Key (hex): " + bytesToHex(keyBytes));
    }


    //testing with plain text in application.properties file  jwt.secret=adminkeyforjwt1234567890adminkeyforjwt
//    private Key getKey() {
//        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
//    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        System.out.println("Decoded Secret Key: " + new String(keyBytes));
        System.out.println("🔑 Decoded Key (hex): " + bytesToHex(keyBytes));


        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    private<T> T extractClaim(String token, Function<Claims,T>claimResolver){
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);

    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName=extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}
