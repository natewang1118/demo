package com.example.demo.controller;


import com.example.demo.service.CoinDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    public static final String VIEW_INDEX = "demo/home/home";
    public static final String VIEW_UPDATE = "demo/home/update";

    @Resource
    private CoinDataService coinDataService;

    @GetMapping("/home")
    public String index() {
        return VIEW_INDEX;
    }

    @RequestMapping("/home/update")
    public String update(Model model) {
        model.addAttribute("main", coinDataService.insertApiData());
        return VIEW_UPDATE;
    }
}
