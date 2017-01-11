package com.example.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by djklaf on 2017/1/10.
 */

@Entity
public class Holiday {

    public Holiday(){

    }

    public Holiday(LocalDate holiday, String name, int isopen) {
        this.holiday = holiday;
        this.name = name;
        this.isopen = isopen;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(nullable = false,length = 10)
    private LocalDate holiday;

    @Column
    private String name;

    /**
    是否开市,0休市，1开市
     */
    @Column(nullable = false)
    private int isopen;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getHoliday() {
        return holiday;
    }

    public void setHoliday(LocalDate holiday) {
        this.holiday = holiday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }
}
