package com.example.quartz;

import com.example.service.HolidayService;
import com.example.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by djklaf on 2017/1/6.
 */
@Component
@EnableScheduling
public class UpdateAllStocksDailyTask {
    private static final Logger log = LoggerFactory.getLogger(UpdateAllStocksDailyTask.class);

    @Autowired
    StockService stockService;

    @Autowired
    HolidayService holidayService;

    @Scheduled(cron = "0 05 15 * * ?")
    public void updateAllStocksDaily(){
        if(holidayService.isCloseday(new Date())){
            return;
        }
        stockService.updateStocks();
    }
}
