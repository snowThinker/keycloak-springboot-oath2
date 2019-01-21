package org.snowman.keycloak.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
 
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String hello(){
        return "world";
    }
}
