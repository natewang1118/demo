package com.example.demo.service.impl;

import com.example.demo.domain.CoinData;
import com.example.demo.service.CoinDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CoinDataServiceImpl extends BaseServiceImpl<CoinData, String> implements CoinDataService {
    
}
