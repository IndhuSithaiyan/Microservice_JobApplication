package com.Job_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@SpringBootApplication
@EnableFeignClients
public class JobAppMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobAppMsApplication.class, args);
	}

//	@Bean
////	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
}
