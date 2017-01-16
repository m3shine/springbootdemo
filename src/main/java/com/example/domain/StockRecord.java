package com.example.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/12.
 */
@Entity
@Table
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String name;

    @Column(nullable = false)
    private String code;

    @Column
    private String market;

    /**
     * 今日开盘价
     */
    @Column
    private Double openPrice;

    /**
     * 昨日收盘价
     */
    @Column
    private Double closePrice;

    /**
     * 成交量（手）
     */
    @Column
    private Double tradeNum;

    /**
     * 成交金额（元）
     */
    @Column
    private Double tradeAmount;

    /**
     * 股价日期
     */
    @Column
    private LocalDate date;

    /**
     * 涨跌金额
     */
    @Column(name = "diff_money")
    private Double diffMoney;

    /**
     * 涨跌幅度
     */
    @Column(name = "diff_rate")
    private Double diffRate;

    /**
     * 换手率
     */
    @Column
    private String turnover;

    /**
     * 市盈率
     */
    @Column
    private String pe;

    /**
     * 市净率
     */
    @Column
    private String pb;

    /**
     * 累计涨跌幅（数据库全部日期累加）
     */
    private Double sumRate;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Double getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Double tradeNum) {
        this.tradeNum = tradeNum;
    }

    public Double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDiffMoney() {
        return diffMoney;
    }

    public void setDiffMoney(Double diffMoney) {
        this.diffMoney = diffMoney;
    }

    public Double getDiffRate() {
        return diffRate;
    }

    public void setDiffRate(Double diffRate) {
        this.diffRate = diffRate;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public Double getSumRate() {
        return sumRate;
    }

    public void setSumRate(Double sumRate) {
        this.sumRate = sumRate;
    }
}
