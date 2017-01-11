package com.example.service;

import com.example.domain.Holiday;
import com.example.domain.HolidayRepository;
import com.example.domain.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/10.
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    DateUtil dateUtil;

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
     数据库初始化休市日，一年只执行一次。
     */
    @Override
    public void init(){
        Holiday[] yuandan = {
                new Holiday(dateUtil.str2Date("2017-01-01"),"元旦",0),
                new Holiday(dateUtil.str2Date("2017-01-02"),"元旦",0),
        };
        Holiday[] chunjie = {
                new Holiday(dateUtil.str2Date("2017-01-27"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-01-28"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-01-29"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-01-30"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-01-31"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-02-01"),"春节",0),
                new Holiday(dateUtil.str2Date("2017-01-02"),"春节",0),
        };
        Holiday[] qingming = {
                new Holiday(dateUtil.str2Date("2017-04-02"),"清明节",0),
                new Holiday(dateUtil.str2Date("2017-04-03"),"清明节",0),
                new Holiday(dateUtil.str2Date("2017-04-04"),"清明节",0),
        };
        Holiday[] laodong = {
                new Holiday(dateUtil.str2Date("2017-04-29"),"劳动节",0),
                new Holiday(dateUtil.str2Date("2017-04-30"),"劳动节",0),
                new Holiday(dateUtil.str2Date("2017-05-01"),"劳动节",0),
        };
        Holiday[] duanwu = {
                new Holiday(dateUtil.str2Date("2017-05-28"),"端午节",0),
                new Holiday(dateUtil.str2Date("2017-05-29"),"端午节",0),
                new Holiday(dateUtil.str2Date("2017-05-30"),"端午节",0),
        };
        Holiday[] guoqing = {
                new Holiday(dateUtil.str2Date("2017-10-01"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-02"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-03"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-04"),"中秋节",0),
                new Holiday(dateUtil.str2Date("2017-10-05"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-06"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-07"),"国庆节",0),
                new Holiday(dateUtil.str2Date("2017-10-08"),"国庆节",0),
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
     * 判断是否节假休市日
     * @return
     */
    public boolean isCloseday(LocalDate date){
        date = dateUtil.str2Date(date.toString());
        if(dateUtil.isWeekend(date)){
            return true;
        }else {
            Holiday holiday = holidayRepository.findByDate(date);
            if(holiday != null){
                return true;
            }
            return false;
        }
    }
}
