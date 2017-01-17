package com.example.web;

import com.example.service.HolidayService;
import com.example.service.StockRecordService;
import com.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    StockRecordService stockRecordService;

    @RequestMapping(value = "/showsh")
    @ResponseBody
    public String showStocks(){
        if(holidayService.isCloseday(LocalDate.now())){
            return "";
        }
        return stockService.showStocks();
    }

    @RequestMapping(value = "/find")
    public String find(Double rate){
        return stockRecordService.findBySumRate(rate).toString();
    }
}
