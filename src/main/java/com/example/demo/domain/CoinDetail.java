package com.example.demo.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "coin_detail")
@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true, exclude = "parent")
@ToString(callSuper = true, doNotUseGetters = true, exclude = "parent")
public class CoinDetail extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id_")
    private CoinData parent;

    @Column(name = "code_")
    private String code;

    @Column(name = "symbol_")
    private String symbol;

    @Column(name = "rate_")
    private String rate;

    @Column(name = "description_")
    private String description;

    @Column(name = "rate_float_")
    private String rateFloat;


}
