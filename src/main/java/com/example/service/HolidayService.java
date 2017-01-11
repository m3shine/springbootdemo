package com.example.service;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayService {

    @Transactional
    void init();

    boolean isCloseday(LocalDate date);
}
