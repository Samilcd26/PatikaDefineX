package com.Hafta1.Hafta1Uygulama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class Hafta1UygulamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hafta1UygulamaApplication.class, args);
	}

}
