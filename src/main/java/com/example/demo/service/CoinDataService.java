package com.example.demo.service;

import com.example.demo.domain.CoinData;

public interface CoinDataService extends BaseService<CoinData, String> {

    void insertApiData();

}
