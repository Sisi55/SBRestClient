package com.example.restclient2.api.vo;


import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
public class JsonVo {

    @XmlElement
    private final String type = "JSON";

    @XmlElement
    private final String message = "This is Json Data!";
}
