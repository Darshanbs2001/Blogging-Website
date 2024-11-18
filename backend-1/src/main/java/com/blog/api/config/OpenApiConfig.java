package com.blog.api.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
@Configuration
@OpenAPIDefinition(
		info=@Info(
				contact=@Contact(
				name="Darshan B S and Bhumika A M",
				email="darshandarsha59@gmail.com"
				
				),
		        description="Open Api documentation for the blogging app ",
		        title="Bloggin Backend end points",
		        version="0.1",
		        license = @License(name = "Licenced by darshan",
		        url = "google.com" 
		        		)
				
		),
		servers= {
				@Server(
						description = "Local ENV",
						url="http://localhost:8080"
						),
				@Server(
						description="Bhumi Env",
						url="http://localhost:9090"
						)
		}
	    
		
		)
public class OpenApiConfig {

}
