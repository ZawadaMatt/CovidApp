package com.github.zawadamatt.CovidApp.repositories;

import com.github.zawadamatt.CovidApp.model.County;
import com.github.zawadamatt.CovidApp.model.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepo extends JpaRepository<County, Long> {

    County findFirstByProvinceOrderByDatesDesc(String province);
    List<County> findCountiesByProvinceOrderByDatesDesc(String province);

}
