package com.example.restclient2.api;

import com.example.restclient2.api.vo.JsonVo;
import com.example.restclient2.api.vo.XmlVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class APIController {

    // xml return
    @GetMapping(value="/xml", produces="application/xml")
    public XmlVo getXmlData(){
        return new XmlVo();
    }

    // json return
    @GetMapping("/json")
    public JsonVo getJsonData(){
        return new JsonVo();
    }

    // check header
    @GetMapping("/entity")
    public ResponseEntity<String> checkHeader(String name, HttpServletRequest httpServletRequest){
        log.info("Hello, {}", name);
        if(!httpServletRequest.getHeader("Authentication").equals("LEMON")){
            return new ResponseEntity<>("permission denied", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("welcom!", HttpStatus.OK);
    }

    // post
    @PostMapping("/post")
    public ResponseEntity<String> postForEntity(String contents){
        log.info("requestbody: {}", contents);
        return new ResponseEntity<>("Success Response", HttpStatus.OK);
    }
}
