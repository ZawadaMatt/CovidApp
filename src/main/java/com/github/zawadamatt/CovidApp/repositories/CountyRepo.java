package com.github.zawadamatt.CovidApp.repositories;

import com.github.zawadamatt.CovidApp.model.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepo extends JpaRepository<County, Long> {



}
