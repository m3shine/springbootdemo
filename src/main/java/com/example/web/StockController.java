package com.example.web;


import com.example.service.HolidayService;
import com.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/9.
 */
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    HolidayService holidayService;

    @RequestMapping(value = "/showAll")
    public String showStocks(){
        if(holidayService.isCloseday(LocalDate.now())){
            return "";
        }
        return stockService.showStocks();
    }
}
