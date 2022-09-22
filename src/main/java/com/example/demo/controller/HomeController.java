package com.example.demo.controller;


import com.example.demo.service.CoinDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomeController {

    @Resource
    private CoinDataService coinDataService;

    @GetMapping("/home")
    public String index() {
        return "home/home";
    }

    @GetMapping("/home/update")
    public String update() {
        coinDataService.insertApiData();
        return "home/home";
    }
}
