package com.sellzee.serviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceResgistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceResgistryApplication.class, args);
	}

}
