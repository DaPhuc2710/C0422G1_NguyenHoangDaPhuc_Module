package com.example.repository.impl;

import com.example.model.Date;
import com.example.repository.IDateRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DateRepository implements IDateRepository {
    private static List<String> days = new ArrayList<>();
    private static List<String> months = new ArrayList<>();
    private static List<String> years = new ArrayList<>();

    static {
        for (int i = 1; i < 32; i++) {
            days.add(i + "");
        }
        for (int i = 1; i < 13; i++) {
            months.add(i + "");
        }
        for (int i = 2019; i <= 2022; i++) {
            years.add(i + "");
        }
    }


    @Override
    public List<String> findDateAll() {
        return days;
    }

    @Override
    public List<String> findMonthAll() {
        return months;
    }

    @Override
    public List<String> findYearAll() {
        return years;
    }
}
