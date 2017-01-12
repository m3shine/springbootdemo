package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/10.
 */
public interface HolidayRepository extends JpaRepository<Holiday,Long>{

    /*from Holiday H需大写，因为JPQL不是从数据表中查询，而是从域模型中查询*/
    @Query("from Holiday h where h.holiday=:holiday and isopen=0")
    Holiday findByDate(@Param("holiday") LocalDate date);
}
