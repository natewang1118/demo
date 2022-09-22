package com.example.demo.repository;

import com.example.demo.domain.CoinData;

public interface CoinDataRepository extends BaseRepository<CoinData, String> {

    CoinData findCoinDataByChartName(String chartName);

    
}
