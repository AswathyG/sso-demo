package com.sso.client.web.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import com.sso.client.web.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class SsoController {

    @Value("${resourceserver.api.url}")
    private String fooApiUrl;

    @Autowired
    private WebClient webClient;

    @GetMapping("/loginUser")
    public String getFoos(Model model) {
        // List<User> user = this.webClient.get()
        // .uri(fooApiUrl)
        // .retrieve()
        // .bodyToMono(new ParameterizedTypeReference<List<User>>() {
        // })
        // .block();
        // model.addAttribute("User", user);
        return "foos";
    }
}
