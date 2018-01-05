package com.domainapi.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Base {

	@RequestMapping("/")
    public String index() {
        return "index.html";
    }

}