package com.example.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by djklaf on 2017/1/9.
 */
public interface StockService {

    @Transactional
    void updateStocks();
}
