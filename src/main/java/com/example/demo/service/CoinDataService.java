package com.example.demo.service;

import com.example.demo.domain.CoinData;
import org.springframework.data.domain.Page;

public interface CoinDataService extends BaseService<CoinData, String> {

    CoinData insertApiData();

    Page page();

    void update(CoinData coinData);
}
