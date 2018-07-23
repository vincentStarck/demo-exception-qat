package com.example.demoexception;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.demoexception.restInterceptor.RestInterceptorLogger;

@SpringBootApplication
public class DemoexceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoexceptionApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RestInterceptorLogger()));
        return restTemplate;
	}
}
