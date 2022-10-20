package com.example.demo.controller;


import com.example.demo.domain.CoinData;
import com.example.demo.repository.CoinDataRepository;
import com.example.demo.repository.CoinDetailRepository;
import com.example.demo.service.CoinDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    public static final String VIEW_INDEX = "demo/home/home";
    public static final String VIEW_UPDATE = "demo/home/update";

    @Resource
    private CoinDataService coinDataService;

    @Resource
    private CoinDataRepository repository;

    @Resource
    private CoinDetailRepository detailRepository;

    @RequestMapping({"/home", ""})
    public String index(Model model) {
        model.addAttribute("page", coinDataService.page());
        return VIEW_INDEX;
    }

    @RequestMapping("/home/search")
    public String search(Model model) {
        coinDataService.insertApiData();
        model.addAttribute("page", coinDataService.page());
        return VIEW_INDEX;
    }

    @RequestMapping("/home/update/{id}")
    public String update(@PathVariable("id") String id,
                         Model model) {
        CoinData main = repository.getReferenceById(id);
        model.addAttribute("main", main);
        return VIEW_UPDATE;
    }

    @RequestMapping("/home/save")
    public String save(@ModelAttribute("main") CoinData coinData, Model model) {
        coinDataService.update(coinData);
        model.addAttribute("page", coinDataService.page());
        return VIEW_INDEX;
    }
}
