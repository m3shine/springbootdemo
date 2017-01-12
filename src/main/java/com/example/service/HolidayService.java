package com.example.service;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayService {

    void init();

    boolean isCloseday(LocalDate date);
}
