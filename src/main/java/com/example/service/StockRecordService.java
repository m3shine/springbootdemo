package com.example.service;

import java.util.List;

/**
 * Created by djklaf on 2017/1/12.
 */
public interface StockRecordService {
    void updateStocks();
    List<Object[]> findBySumRate(Double rate);
}
