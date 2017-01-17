package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by djklaf on 2017/1/12.
 */
public interface StockRecordRepository extends JpaRepository<StockRecord,Long> {
    @Query("select sr.code,sr.name,sum(sr.diffRate) from StockRecord sr " +
            "group by sr.code " +
            "having sum(sr.diffRate)  >= :rate ")
    List<Object[]> findBySumRate(@Param("rate") Double rate);


}
