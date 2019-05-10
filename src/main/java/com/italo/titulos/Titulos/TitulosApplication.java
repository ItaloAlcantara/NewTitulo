package com.italo.titulos.Titulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication

public class TitulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TitulosApplication.class, args);
	}
	
	/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String result =encoder.encode("123");
	System.out.println(result);
	 */
}
