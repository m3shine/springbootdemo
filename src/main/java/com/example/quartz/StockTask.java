package com.example.quartz;

import com.example.service.HolidayService;
import com.example.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/6.
 */
@Component
@EnableScheduling
public class StockTask {
    private static final Logger log = LoggerFactory.getLogger(StockTask.class);

    @Autowired
    StockService stockService;

    @Autowired
    HolidayService holidayService;

    //@Scheduled(cron = "0 05 15 * * ?")
    public void updateStockRecordDaily(){
        if(holidayService.isCloseday(LocalDate.now())){
            return;
        }
        //stockService.updateStocks();
    }
}
