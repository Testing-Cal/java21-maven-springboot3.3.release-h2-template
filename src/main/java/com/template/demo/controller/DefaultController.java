package com.template.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nsingotam
 */
@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class DefaultController {

    @Value("${spring.application.title}")
    private String title;

    @GetMapping
    public ResponseEntity<String> getDefault() {
        return new ResponseEntity<String>(title + "Hello! You have successfully set up your Java21 Maven SpringBoot:3.3.1 environment by using the Lazsa template. You're all set to start coding.", HttpStatus.OK);
    }

}