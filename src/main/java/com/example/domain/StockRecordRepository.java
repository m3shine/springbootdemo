package com.example.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by djklaf on 2017/1/12.
 */
public interface StockRecordRepository extends JpaRepository<StockRecord,Long> {
    /*@Query("select sr , ROUND(sum(sr.diff_rate),2)  rate from StockRecord sr\n" +
            "group by sr.code\n" +
            "having sr.rate >= :rate")
    Page<StockRecord> findBySumRate(@Param("rate") Double sumrate);*/

}
