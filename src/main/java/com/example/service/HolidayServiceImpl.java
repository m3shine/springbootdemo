package com.example.service;

import com.example.domain.Holiday;
import com.example.domain.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    HolidayRepository holidayRepository;

    /*
　   2017休市安排
　　（一）元旦：1月1日（星期日）至1月2日（星期一）休市，1月3日（星期二）起照常开市。2016年12月31日（星期六）为周末休市。
　　（二）春节：1月27日（星期五）至2月2日（星期四）休市，2月3日（星期五）起照常开市。1月22日（星期日）、2月4日（星期六）为周末休市。
　　（三）清明节：4月2日（星期日）至4月4日（星期二）休市，4月5日（星期三）起照常开市。4月1日（星期六）为周末休市。
　　（四）劳动节：4月29日（星期六）至5月1日（星期一）休市，5月2日（星期二）起照常开市。
　　（五）端午节：5月28日（星期日）至5月30日（星期二）休市，5月31日（星期三）起照常开市。5月27日（星期六）为周末休市。
　　（六）中秋节、国庆节：10月1日（星期日）至10月8日（星期日）休市，10月9日（星期一）起照常开市。9月30日（星期六）为周末休市。
    */
    /**
     初始化休市日
     */
    @Override
    public void init(){
        Holiday[] yuandan = {
                new Holiday(convertDate("2017-01-01"),"元旦",0),
                new Holiday(convertDate("2017-01-02"),"元旦",0),
        };
        Holiday[] chunjie = {
                new Holiday(convertDate("2017-01-27"),"春节",0),
                new Holiday(convertDate("2017-01-28"),"春节",0),
                new Holiday(convertDate("2017-01-29"),"春节",0),
                new Holiday(convertDate("2017-01-30"),"春节",0),
                new Holiday(convertDate("2017-01-31"),"春节",0),
                new Holiday(convertDate("2017-02-01"),"春节",0),
                new Holiday(convertDate("2017-01-02"),"春节",0),
        };
        Holiday[] qingming = {
                new Holiday(convertDate("2017-04-02"),"清明节",0),
                new Holiday(convertDate("2017-04-03"),"清明节",0),
                new Holiday(convertDate("2017-04-04"),"清明节",0),
        };
        Holiday[] laodong = {
                new Holiday(convertDate("2017-04-29"),"劳动节",0),
                new Holiday(convertDate("2017-04-30"),"劳动节",0),
                new Holiday(convertDate("2017-05-01"),"劳动节",0),
        };
        Holiday[] duanwu = {
                new Holiday(convertDate("2017-05-28"),"端午节",0),
                new Holiday(convertDate("2017-05-29"),"端午节",0),
                new Holiday(convertDate("2017-05-30"),"端午节",0),
        };
        Holiday[] guoqing = {
                new Holiday(convertDate("2017-10-01"),"国庆节",0),
                new Holiday(convertDate("2017-10-02"),"国庆节",0),
                new Holiday(convertDate("2017-10-03"),"国庆节",0),
                new Holiday(convertDate("2017-10-04"),"中秋节",0),
                new Holiday(convertDate("2017-10-05"),"国庆节",0),
                new Holiday(convertDate("2017-10-06"),"国庆节",0),
                new Holiday(convertDate("2017-10-07"),"国庆节",0),
                new Holiday(convertDate("2017-10-08"),"国庆节",0),
        };

        for (Holiday h : yuandan){
            holidayRepository.save(h);
        }
        for (Holiday h : chunjie){
            holidayRepository.save(h);
        }
        for (Holiday h : qingming){
            holidayRepository.save(h);
        }
        for (Holiday h : laodong){
            holidayRepository.save(h);
        }
        for (Holiday h : duanwu){
            holidayRepository.save(h);
        }
        for (Holiday h : guoqing){
            holidayRepository.save(h);
        }
    }
    /**
     * 判断是否是休市
     * @return
     */
    public boolean isCloseday(Date date){
        Holiday holiday1 = holidayRepository.findByDate(convertDate(date.toString()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(holiday1.getHoliday());

        if(holiday1!=null || isWeekend(calendar)){
            return true;
        }
        return false;
    }

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

    public Date convertDate(String date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date dt= null;
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }
}
