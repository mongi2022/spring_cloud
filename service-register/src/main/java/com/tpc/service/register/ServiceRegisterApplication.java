package com.tpc.service.register;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisterApplication.class, args);}
		@Bean
		CommandLineRunner start(Environment env){
			return args ->{
				System.out.println(env.getProperty("eureka.client.fetchRegistry"));
			};
		}
	}


