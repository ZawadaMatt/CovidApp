package com.github.zawadamatt.CovidApp.controllers;

import com.github.zawadamatt.CovidApp.model.County;
import com.github.zawadamatt.CovidApp.repositories.CountyRepo;
import com.github.zawadamatt.CovidApp.repositories.DatesRepo;
import com.github.zawadamatt.CovidApp.service.ReadCSV;
import com.github.zawadamatt.CovidApp.service.TypicalServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    private EntityManager entityManager;
    private CountyRepo countyRepo;
    private DatesRepo datesRepo;
    private ReadCSV readCSV;
    private TypicalServ typicalServ;

    @Autowired
    MainController(EntityManager entityManager, CountyRepo countyRepo, DatesRepo datesRepo, ReadCSV readCSVl, TypicalServ typicalServ) {
        this.entityManager = entityManager;
        this.countyRepo = countyRepo;
        this.datesRepo = datesRepo;
        this.readCSV = readCSVl;
        this.typicalServ = typicalServ;
    }

    @GetMapping("/")
    public String get(Model model) {
        readCSV.readResponse(readCSV.connection());
        County actualWholeLand = countyRepo.findFirstByProvinceOrderByDatesDesc("Cały kraj");
        model.addAttribute("actualWholeCountry", countyRepo.findFirstByProvinceOrderByDatesDesc("Cały kraj"));
        model.addAttribute("percentWholeCountryToYesterday", typicalServ.percentComparedYesterdayWholeCountry());
        model.addAttribute("percentComparedYesterdayDeathsWholeCountry", typicalServ.percentComparedYesterdayDeathsWholeCountry());
        model.addAttribute("percentComparedYesterdayTestsWholeCountry", typicalServ.percentComparedYesterdayTestWholeCountry());
        model.addAttribute("percentComparedYesterdayRecoveredWholeCountry", typicalServ.percentComparedYesterdayRecoveredWholeCountry());
        model.addAttribute("dates", typicalServ.dataToChartDate());
        model.addAttribute("dataToChart", typicalServ.dataToChart());
        return "index.html";
    }
}
