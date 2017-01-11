package com.example.domain.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by djklaf on 2017/1/11.
 */
@Component
public class DateUtil {

    /**
     * 判断是否是周末
     * @return
     */
    public boolean isWeekend(Calendar cal){
        int week=cal.get(Calendar.DAY_OF_WEEK)-1;
        //0代表周日，6代表周六
        if(week ==6 || week==0){
            return true;
        }
        return false;
    }

    /**
     * 判断是否是周末
     * @return
     */
    public boolean isWeekend(LocalDate date){
        DayOfWeek weekDay = date.getDayOfWeek();
        if(DayOfWeek.SATURDAY.equals(weekDay) || DayOfWeek.SUNDAY.equals(weekDay)){
            return true;
        }
        return false;
    }


    /**
     * String转LocalDate
     * @param strDate
     * @return
     */
    public LocalDate str2Date(String strDate){
        LocalDate date = null;
        try {
            date = LocalDate.parse(strDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转String
     * @param date
     * @return
     */
    public String date2Str(Date date){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String str = null;
        try {
            str = df.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
