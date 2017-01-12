package com.example.web;

import com.example.service.HolidayService;
import com.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by djklaf on 2017/1/12.
 * 数据库字典初始化类
 */
@RestController
@RequestMapping("/init")
public class InitData {
    @Autowired
    HolidayService holidayService;

    @Autowired
    StockService stockService;

    /**
     * 初始化上证股票数据
     */
    @RequestMapping("/sh")
    public void initSHStocks(){
        stockService.initSHStocks();
    }

    /**
     * 初始化节假日
     */
    @RequestMapping("/holiday")
    void initHoliday(){
        holidayService.init();
    }
}
