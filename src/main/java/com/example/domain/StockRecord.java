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

    /**
     * {"showapi_res_code":0,"showapi_res_error":"","showapi_res_body":{"ret_code":0,"stockMarket":{"todayMax":"13.790","highLimit":"15.19","buy5_n":"1900","buy2_n":"1000","tradeNum":"22632017","buy2_m":"13.490","buy5_m":"13.460","sell3_m":"13.530","openPrice":"13.790","buy3_m":"13.480","buy4_m":"13.470","buy4_n":"5800","date":"2017-01-12","sell5_n":"19300","buy3_n":"2800","sell5_m":"13.550","closePrice":"13.810","time":"15:00:00","turnover":"1.94%","sell3_n":"41300","name":"皖通高速","sell4_n":"10700","downLimit":"12.43","sell4_m":"13.540","tradeAmount":"305907834.000","swing":"5.0","diff_rate":"-2.17","yestodayClosePrice":"13.810","sell1_n":"85600","todayMin":"13.100","sell1_m":"13.510","max52":"","diff_money":"-0.3","code":"600012","nowPrice":"13.510","sell2_m":"13.520","min52":"","sell2_n":"3100","buy1_m":"13.500","pe":"23.94","buy1_n":"63500","market":"sh","pb":"2.65"}}}
     */
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
}
