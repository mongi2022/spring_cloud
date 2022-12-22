package com.tpc.servicecompany;

import com.tpc.servicecompany.entities.Company;
import com.tpc.servicecompany.repositories.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

@Bean
	CommandLineRunner start(CompanyRepository companyRepository,Environment env){
		return args -> {
			System.out.println(env.getProperty("server.port"));
			Stream.of("A","B","C").forEach(c->{
				companyRepository.save(new Company(null,c,100+Math.random()*900));
			});
			companyRepository.findAll().forEach(System.out::println);

		};
	}
}
