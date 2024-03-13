package com.spendwise.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        final String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response); // If no token is present, continue down the filter chain
            return;
        }

        final String token = header.split(" ")[1].trim();
        if (!validateToken(token)) {
            chain.doFilter(request, response); // If the token is invalid, continue down the filter chain
            return;
        }

        // Extract claims and set up Spring Security Context
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String email = claims.getSubject();

        // Setting up UserDetails without authorities for now
        UserDetails userDetails = User.withUsername(email)
                                      .password("") // Password is not needed for authentication but must be non-null
                                      .authorities(new ArrayList<>()) // No authorities or roles
                                      .build();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private boolean validateToken(String token) {
        // Implement token validation logic here
        // For simplicity, this implementation assumes all tokens are valid
        // You should add your token validation logic (e.g., checking expiration)
        return true;
    }
}
