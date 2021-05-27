package com.kwu.propictures.app;

//import com.kwu.propictures.repository.SecurityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//This is add to test rebase

@SpringBootApplication
@EnableCaching
@EnableCircuitBreaker
@EnableEurekaServer
public class ProPicturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProPicturesApplication.class, args);
	}

}
