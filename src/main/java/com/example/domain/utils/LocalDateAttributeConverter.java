package com.example.domain.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

/**
 * Created by djklaf on 2017/1/11.
 * 此类的存在是因为当前jpa版本（1.4.3）不支持jdk8的LocalDate专门写的，当程序执行创建表的时候可自动将JAVA的LocalDate映射为Date而不是BLOB
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}