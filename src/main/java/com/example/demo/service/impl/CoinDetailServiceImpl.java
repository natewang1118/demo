package com.example.demo.service.impl;

import com.example.demo.domain.CoinDetail;
import com.example.demo.service.CoinDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CoinDetailServiceImpl extends BaseServiceImpl<CoinDetail, String> implements CoinDetailService {

}
