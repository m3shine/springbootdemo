package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by djklaf on 2017/1/12.
 */
public interface StockRecordRepository extends JpaRepository<StockRecord,Long> {
}
