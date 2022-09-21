package com.example.demo.domain;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "coin-data")
public class CoinData {


    private String chartName;
    private String disclaimer;
    private String updated;
    private String updatedISO;
    private String updateDuk;
    private List<CoinDetail> detailList;


}
