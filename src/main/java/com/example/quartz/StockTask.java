package com.example.quartz;

import com.example.service.HolidayService;
import com.example.service.StockRecordService;
import com.example.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Autowired
    StockRecordService stockRecordService;



    /**
     * 有新股则插入，没有则不更新.
     * 时间要早于记录更新
     */
    @Scheduled(cron = "0 00 10 * * ?")
    public void addNewStocks(){
        stockService.addNewStocks();
    }

    /**
     * 每天更新股票记录
     */
    @Scheduled(cron = "0 05 15 * * ?")
    public void updateStockRecordDaily(){
        if(holidayService.isCloseday(LocalDate.now())){
            return;
        }
        stockRecordService.updateStocks();
    }
}
