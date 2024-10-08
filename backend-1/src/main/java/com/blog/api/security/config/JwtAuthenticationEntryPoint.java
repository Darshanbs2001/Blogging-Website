package com.blog.api.security.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
 * 
 * 
 * @Override public void commence(HttpServletRequest request,
 * HttpServletResponse response, AuthenticationException authException) throws
 * IOException, ServletException {
 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access Denied");
 * String jwt = request.getHeader("authorization");
 * if(jwt==""||!jwt.startsWith("Bearer ")) { return; } else { jhp.extract(jwt);
 * }
 * 
 * }
 * 
 * }
 */
