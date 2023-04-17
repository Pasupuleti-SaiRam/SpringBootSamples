package com.employee.Util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${app.secret}")
	private String secret;
	
	 //read claims/payload
	public Claims getClaims(String token) {
		
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
		
		
	}
	// read token exp date
	public Date getExpDate(String token)
	{
		return getClaims(token).getExpiration();
	}
	// read subject/username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	// vaidate exp date
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	
	//validate username in token and db name same or not
	public boolean validateToken(String token, String username) {
		String tokenUserName = getUsername(token);
		return(username.equals(tokenUserName)&& !isTokenExp(token));
	}
	
	
	// generate Token
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(60)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
		
	}

}
