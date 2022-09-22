package com.example.demo.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "coin_data")
@Data
public class CoinData extends AbstractEntity {


    @Column(name = "chart_name_")
    private String chartName;

    @Column(name = "disclaimer_")
    private String disclaimer;

    @Column(name = "updated_")
    private String updated;

    @Column(name = "updated_iso_")
    private String updatedISO;

    @Column(name = "update_duk_")
    private String updateDuk;

    @OneToMany(mappedBy = "parent")
    private List<CoinDetail> children;


}
