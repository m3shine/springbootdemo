package com.example.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by djklaf on 2017/1/9.
 */
@Entity
//@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double settlement;

    @Column(nullable = false)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSettlement() {
        return settlement;
    }

    public void setSettlement(Double settlement) {
        this.settlement = settlement;
    }
}
