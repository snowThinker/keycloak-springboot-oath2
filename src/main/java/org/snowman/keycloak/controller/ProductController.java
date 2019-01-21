package org.snowman.keycloak.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowman.keycloak.utils.SecurityUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);
    
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> handleCustomersRequest(Principal principal) {
        log.info("Accessing products with the following access token:\n{}", SecurityUtils.getAccessTokenPayload(principal));
        List<String> list = new ArrayList<String>();
        list.add("iPhone");
        list.add("iPad");
        list.add("iMac");
        return list;
    }


}
