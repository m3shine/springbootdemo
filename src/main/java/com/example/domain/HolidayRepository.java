package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayRepository extends JpaRepository<Holiday,Long>{

    /*from Holiday H需大写*/
    @Query("from Holiday h where h.holiday=:holiday and isopen=0")
    Holiday findByDate(@Param("holiday") LocalDate date);
}
