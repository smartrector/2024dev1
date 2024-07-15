package com.study.spring.security.filter;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request)  throws ServletException {
        //true not checkint
        String path = request.getRequestURI();

        log.info("check uri ---------------"+path);


        //false check
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("---------------doFilterInternal-----------------");
        log.info("---------------doFilterInternal-----------------");
        log.info("---------------doFilterInternal-----------------");


        String authHeaderStr = request.getHeader("Authorization");

       

    }
}
