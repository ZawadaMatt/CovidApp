package com.github.zawadamatt.CovidApp.service;

import com.github.zawadamatt.CovidApp.model.County;
import com.github.zawadamatt.CovidApp.model.Dates;
import com.github.zawadamatt.CovidApp.repositories.CountyRepo;
import com.github.zawadamatt.CovidApp.repositories.DatesRepo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadCSV {

    private DatesRepo datesRepo;
    private CountyRepo countyRepo;

    @Autowired
    public ReadCSV(DatesRepo datesRepo, CountyRepo countyRepo) {
        this.countyRepo = countyRepo;
        this.datesRepo = datesRepo;
    }

    String apiUrl = "https://www.arcgis.com/sharing/rest/content/items/6ff45d6b5b224632a672e764e04e8394/data";

    public HttpURLConnection connection() {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setRequestMethod("GET");
            return con;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readResponse(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "Windows-1250"));
            List<String> list = in.lines().collect(Collectors.toList());
            list.remove(0);
            if (!datesRepo.existsDatesByDate(LocalDate.parse(list.get(0).split(";")[15]))) {
                Dates dates = new Dates(LocalDate.parse(list.get(0).split(";")[15]), new HashSet<>());
                List<County> counties = new LinkedList<>();
                for (String s : list) {
                    String[] splited = s.split(";");
                    County county = County.builder()
                            .province(splited[0])
                            .county(splited[1])
                            .caseCount(Integer.parseInt(splited[2]))
                            .casePer10k(Float.parseFloat(splited[3]))
                            .deaths(Integer.parseInt(splited[4]))
                            .onlyCovidDeaths(Integer.parseInt(splited[5]))
                            .deathsCovidAndCommon(Integer.parseInt(splited[6]))
                            .commissioningPOZ(Integer.parseInt(splited[7]))
                            .recovered(Integer.parseInt(splited[8]))
                            .involvedInQuarantine(Integer.parseInt(splited[9]))
                            .testsCount(Integer.parseInt(splited[10]))
                            .positiveTests(Integer.parseInt(splited[11]))
                            .negativeTests(Integer.parseInt(splited[12]))
                            .otherTests(Integer.parseInt(splited[13]))
                            .territory(splited[14])
                            .actualDate(splited[15])
                            .dates(dates)
                            .build();
                    dates.getCountySet().add(county);
                    counties.add(county);
                }
                countyRepo.saveAll(counties);
                datesRepo.save(dates);
            }
            else {
                in.close();
                return;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
