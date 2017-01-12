package com.example.service;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/9.
 */
public interface StockService {

    void initSHStocks();

    String showStocks();

    String pickStocks(LocalDate date, Double percent);

    void addNewStocks();

    Boolean haveNewStocks();
}
