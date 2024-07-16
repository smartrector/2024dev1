package com.study.spring.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter{
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		String path = request.getRequestURI();
		
		log.info("check uri" + path);
		
		if(path.startsWith("/api/member/")) {
			return true;
		}
		
		return false;
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
