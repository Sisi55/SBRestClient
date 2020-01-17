package com.example.restclient2.restclient;

import com.example.restclient2.api.vo.JsonVo;
import com.example.restclient2.api.vo.XmlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestTemplateUtil {

    private static RestTemplate restTemplate;

    @Autowired
    public RestTemplateUtil(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public static XmlVo getXmlResponse(){
        return restTemplate.getForObject("http://localhost:8080/xml", XmlVo.class);
    }

    public static JsonVo getJsonResponse(){
        return restTemplate.getForObject("http://localhost:8080/json", JsonVo.class);
    }

    public static ResponseEntity<String> getResponseEntity(String key){
        // header setting
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authentication", key);

        HttpEntity<Map<String,String>> httpEntity = new HttpEntity<>(headers);

        Map<String,String> params = new HashMap<>();
        params.put("name", "sisi");

        // 순서대로, url, method, entity(header,params), return type
        return restTemplate.exchange("http://localhost:8080/entity?name={name}", HttpMethod.GET, httpEntity, String.class, params);
    }

    public static ResponseEntity<String> post(){
        return restTemplate.postForEntity("http://localhost:8080/post", "Post Request", String.class);
    }
}
