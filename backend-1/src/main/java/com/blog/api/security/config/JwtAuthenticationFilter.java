package com.blog.api.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blog.api.services.UserDetailsImplementation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtService js;
	@Autowired
	ApplicationContext applicationContext;
	private UserDetailsImplementation getUserService() {
        return applicationContext.getBean(UserDetailsImplementation.class);
    }
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, java.io.IOException { // TODO Auto-generated method stub
		final String authHeader = request.getHeader("Authorization");
		//System.out.println(authHeader);
		final String jwt;
		System.out.println("hello from the jwt filter");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			System.out.println("executed the first codition");
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);
		String userEmail = js.extract(jwt);
		// extract the
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			System.out.println("executed the second condition");
			UserDetails details=getUserService().loadUserByUsername(userEmail);
			if(details!=null && js.validate(jwt)) {
				System.out.println(details.getUsername());
				System.out.println(details.getAuthorities());
				UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
						userEmail,
						details.getPassword(),
						details.getAuthorities()
						);
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			
		}
         filterChain.doFilter(request, response);
	}

}
