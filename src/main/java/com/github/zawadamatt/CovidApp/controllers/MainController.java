package com.github.zawadamatt.CovidApp.controllers;

import com.github.zawadamatt.CovidApp.repositories.CountyRepo;
import com.github.zawadamatt.CovidApp.repositories.DatesRepo;
import com.github.zawadamatt.CovidApp.service.ReadCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;

@Controller
public class MainController {

    private EntityManager entityManager;
    private CountyRepo countyRepo;
    private DatesRepo datesRepo;
    private ReadCSV readCSV;

    @Autowired
    MainController(EntityManager entityManager, CountyRepo countyRepo, DatesRepo datesRepo, ReadCSV readCSVl) {
        this.entityManager = entityManager;
        this.countyRepo = countyRepo;
        this.datesRepo = datesRepo;
        this.readCSV = readCSVl;
    }

    @GetMapping("/")
    @ResponseBody
    public String get(Model model) {
        readCSV.readResponse(readCSV.connection());
        return "readCSV.readResponse(readCSV.connection())";
    }
}
