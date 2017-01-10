package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayRepository extends JpaRepository<Holiday,Long>{

    /*Holiday 需大写*/
    @Query("from Holiday h where h.holiday=:holiday")
    Holiday findByDate(@Param("holiday") Date date);
}
