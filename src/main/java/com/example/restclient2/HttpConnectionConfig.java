package com.example.restclient2;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.apache.http.client.HttpClient;

//import java.net.http.HttpClient;

@Configuration
public class HttpConnectionConfig {
    // Custom RestTemplate

    @Bean
    public RestTemplate getCustomRestTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(2000);
        httpRequestFactory.setReadTimeout(3000);
        // HttpClient 에 connection pool 설정
        HttpClient httpClient = HttpClientBuilder.create()
                // connection pool 갯수
                .setMaxConnTotal(200)
                // IP, Port 당 연결 제한 갯수
                .setMaxConnPerRoute(20)
                .build();
        httpRequestFactory.setHttpClient(httpClient);

        return new RestTemplate(httpRequestFactory);
    }
}
