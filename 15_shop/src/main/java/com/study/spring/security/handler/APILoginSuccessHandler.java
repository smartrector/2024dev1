package com.study.spring.security.handler;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;


@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {
	
	
	
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("-------------------------------------");
        log.info(authentication);
        log.info("-------------------------------------");
        
        response.getWriter().write("Login Successful!");

//        MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();



    }
}
