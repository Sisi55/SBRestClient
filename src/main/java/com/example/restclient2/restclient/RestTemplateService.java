package com.example.restclient2.restclient;

import com.example.restclient2.api.vo.JsonVo;
import com.example.restclient2.api.vo.XmlVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestTemplateService {

    public XmlVo getXmlData(){
        return RestTemplateUtil.getXmlResponse();
    }

    public JsonVo getJsonData(){
        return RestTemplateUtil.getJsonResponse();
    }

    public ResponseEntity<String> getEntity(String key){
        return RestTemplateUtil.getResponseEntity(key);
    }

    public ResponseEntity<String> addData(){
        return RestTemplateUtil.post();
    }
}
