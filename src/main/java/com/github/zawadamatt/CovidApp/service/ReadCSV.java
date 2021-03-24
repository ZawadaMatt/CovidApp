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
            datesRepo.findByDate(LocalDate.parse(list.get(0).split(";")[15]));
            if (datesRepo.findByDate(LocalDate.parse(list.get(0).split(";")[15])) == null) {
                Dates dates = new Dates(LocalDate.parse(list.get(0).split(";")[15]), new HashSet<>());
            }
            else {
                return;
            }
            for (String s : list) {
                String[] splited = s.split(";");

            }

            in.close();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public List<County> bindToCounty(String csvToBind) {

        CsvToBean<County> csvToBean = new CsvToBeanBuilder(new StringReader(csvToBind))
                .withSkipLines(1)
                .withSeparator(';')
                .withEscapeChar('\n')
                .withType(County.class)
                .build();
        List<County> result = csvToBean.parse();
        return null;
    }
}
