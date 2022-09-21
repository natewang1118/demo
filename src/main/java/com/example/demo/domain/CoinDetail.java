package com.example.demo.domain;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "coin-detail")
public class CoinDetail {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    private String rateFloat;


}
