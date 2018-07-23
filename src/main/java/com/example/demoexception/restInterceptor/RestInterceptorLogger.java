package com.example.demoexception.restInterceptor;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestInterceptorLogger implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
	}
	
	  private void logRequest(HttpRequest request, byte[] body) throws IOException {

	        log.info("===========================request begin=============================================");
	        log.info("URI         : {}", request.getURI().toString());
	        log.info("Method      : {}", request.getMethod().toString());
	        log.info("Headers     : {}", request.getHeaders());
	        log.info("Request body: {}", new String(body, "UTF-8"));
	        log.info("==========================request end================================================");

	    }

	    private void logResponse(ClientHttpResponse response) throws IOException {

	        log.info("============================response begin===========================================");
	        log.info("Headers      : {}", response.getHeaders());
	        log.info("Status code  : {}", response.getStatusCode().toString());
	        log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
	        log.info("=======================response end=================================================");
	    }

}
