package com.blog.api;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecretKeyBuilder;
import jakarta.xml.bind.DatatypeConverter;

@SpringBootTest
class Backend1ApplicationTests {

	@Test
	void contextLoads() {
		 SecretKey key = Jwts.SIG.HS512.key().build();
		 String printHexBinary = DatatypeConverter.printHexBinary(key.getEncoded());
		 System.out.println("key="+printHexBinary);
	}

}
