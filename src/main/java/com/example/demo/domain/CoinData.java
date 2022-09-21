package com.example.demo.domain;


import lombok.Data;

import java.util.List;

@Data
public class CoinData {


    private String chartName;
    private String disclaimer;
    private String updated;
    private String updatedISO;
    private String updateDuk;
    private List<CoinDetail> detailList;


}
