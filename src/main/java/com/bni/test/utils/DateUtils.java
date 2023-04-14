package com.bni.test.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

//@Configuration
public class DateUtils {

//    @Bean
    public static Date parseDate(String birthDate) {
        LocalDate localDate = LocalDate.parse(birthDate);
        Date formatedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return formatedDate;
    }
}
