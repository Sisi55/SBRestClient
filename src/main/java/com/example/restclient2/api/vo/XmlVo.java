package com.example.restclient2.api.vo;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@XmlRootElement
public class XmlVo {

    @XmlElement
    private final String type = "XML";

    @XmlElement
    private final String message = "This is Xml Data!!";
}
