package com.example.service;

import com.example.domain.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayService {
    void init();
    boolean isCloseday(Date date);
}
