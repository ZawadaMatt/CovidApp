package com.github.zawadamatt.CovidApp.repositories;

import com.github.zawadamatt.CovidApp.model.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DatesRepo extends JpaRepository<Dates, Long> {

    Dates findByDate(String date);
    boolean existsDatesByDate(LocalDate date);
}
