package com.example.service;

import com.example.domain.Holiday;
import com.example.domain.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    HolidayRepository holidayRepository;

    /**
     初始化休市日
     */
    @Override
    public void init(){
        Holiday holiday = new Holiday();
        for (Holiday h :holiday.getHolidayList()){
            holidayRepository.save(h);
        }
    }

    public boolean isCloseday(Date date){
        Holiday holiday = new Holiday();
        holiday.setHoliday(holiday.convertDate(date.toString()));
        Holiday holiday1 = holidayRepository.findByDate(holiday.getHoliday());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(holiday1.getHoliday());

        if(holiday1!=null || holiday1.isWeekend(calendar)){
            return true;
        }
        return false;
    }
}
