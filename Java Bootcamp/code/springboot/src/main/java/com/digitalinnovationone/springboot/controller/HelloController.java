package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloMessage () {
        return "Hello World!";
    }

    @Value("${HOME}")
    private String envVariable;

    @GetMapping("/envVariable")
    public String getEnvVariable() {
        return "O path da pasta home é " + envVariable;
    }

    // quando não houver nenhuma variável de ambiente
    // após os : vem um valor default
    @Value("${ENV_DB_URL: Nenhuma}")
    private String envVar;

    @GetMapping("/envVar")
    public String getEnvVar() {
        return "Environment Variable is " + envVar;
    }
}
