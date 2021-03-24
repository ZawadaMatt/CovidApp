package com.github.zawadamatt.CovidApp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dates {

    @Id
    private LocalDate date;
    @OneToMany(mappedBy = "dates")
    private Set<County> countySet = new HashSet<>();

    public Dates() {

    }

    public Dates(LocalDate date, Set<County> countySet) {
        this.date = date;
        this.countySet = countySet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<County> getCountySet() {
        return countySet;
    }

    public void setCountySet(Set<County> countySet) {
        this.countySet = countySet;
    }
}
