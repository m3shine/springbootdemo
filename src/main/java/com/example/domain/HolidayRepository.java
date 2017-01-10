package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayRepository extends JpaRepository<Holiday,Long>{

    @Query("from holiday h where h.holiday=:holiday")
    Holiday findByDate(@Param("holiday") Date date);
}
