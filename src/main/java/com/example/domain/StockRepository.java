package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by djklaf on 2017/1/9.
 */
public interface StockRepository extends JpaRepository<Stock,Long> {
    
}
