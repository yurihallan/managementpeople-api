package com.dio.managerpeoplenapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class ManagerpersonController {

    @GetMapping
    public String getBook(){
        return "APi Test!";
    }
    
}
