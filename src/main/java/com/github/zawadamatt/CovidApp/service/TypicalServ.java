package com.github.zawadamatt.CovidApp.service;

import com.github.zawadamatt.CovidApp.model.County;
import com.github.zawadamatt.CovidApp.repositories.CountyRepo;
import com.github.zawadamatt.CovidApp.repositories.DatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypicalServ {

    private final DatesRepo datesRepo;
    private final CountyRepo countyRepo;

    @Autowired
    public TypicalServ(DatesRepo datesRepo, CountyRepo countyRepo) {
        this.countyRepo = countyRepo;
        this.datesRepo = datesRepo;
    }

    public float percentComparedYesterdayWholeCountry() {
        List<County> countyList = countyRepo.findCountiesByProvinceOrderByDatesDesc("Cały kraj");
        float percent = ((float) countyList.get(0).getCaseCount() - (float) countyList.get(1).getCaseCount()) / (float) countyList.get(1).getCaseCount() * 100f;
        return Math.round(percent * 100.0) / 100.0f;
    }

    public float percentComparedYesterdayDeathsWholeCountry() {
        List<County> countyList = countyRepo.findCountiesByProvinceOrderByDatesDesc("Cały kraj");
        float percent = ((float) countyList.get(0).getDeaths() - (float) countyList.get(1).getDeaths()) / (float) countyList.get(1).getDeaths() * 100f;
        return Math.round(percent * 100.0) / 100.0f;
    }

    public float percentComparedYesterdayTestWholeCountry() {
        List<County> countyList = countyRepo.findCountiesByProvinceOrderByDatesDesc("Cały kraj");
        float percent = ((float) countyList.get(0).getTestsCount() - (float) countyList.get(1).getTestsCount()) / (float) countyList.get(1).getTestsCount() * 100f;
        return Math.round(percent * 100.0) / 100.0f;
    }


}
