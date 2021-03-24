package com.github.zawadamatt.CovidApp.model;

import lombok.Builder;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
@Builder
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String province;
    @Column
    private String county;
    @Column(name = "case_count")
    private int caseCount;
    @Column(name = "case_per_10k")
    private float casePer10k;
    @Column
    private int deaths;
    @Column(name = "only_covid_deaths")
    private int onlyCovidDeaths;
    @Column(name = "deaths_covid_and_common")
    private int deathsCovidAndCommon;
    @Column(name = "commissioning_POZ")
    private int commissioningPOZ;
    @Column
    private int recovered;
    @Column(name = "involved_in_quarantine")
    private int involvedInQuarantine;
    @Column(name = "tests_count")
    private int testsCount;
    @Column(name = "positive_tests")
    private int positiveTests;
    @Column(name = "negative_tests")
    private int negativeTests;
    @Column(name = "other_tests")
    private int otherTests;
    @Column
    private String territory;
    @Column(name = "actual_date")
    private String actualDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Dates dates;

    public County() {

    }

    public County(long id, String province, String county, int caseCount, float casePer10k, int deaths, int onlyCovidDeaths, int deathsCovidAndCommon, int commissioningPOZ, int recovered, int involvedInQuarantine, int testsCount, int positiveTests, int negativeTests, int otherTests, String territory, String actualDate, Dates dates) {
        this.id = id;
        this.province = province;
        this.county = county;
        this.caseCount = caseCount;
        this.casePer10k = casePer10k;
        this.deaths = deaths;
        this.onlyCovidDeaths = onlyCovidDeaths;
        this.deathsCovidAndCommon = deathsCovidAndCommon;
        this.commissioningPOZ = commissioningPOZ;
        this.recovered = recovered;
        this.involvedInQuarantine = involvedInQuarantine;
        this.testsCount = testsCount;
        this.positiveTests = positiveTests;
        this.negativeTests = negativeTests;
        this.otherTests = otherTests;
        this.territory = territory;
        this.actualDate = actualDate;
        this.dates = dates;
    }

    public Dates getDates() {
        return dates;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public long getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(int caseCount) {
        this.caseCount = caseCount;
    }

    public float getCasePer10k() {
        return casePer10k;
    }

    public void setCasePer10k(float casePer10k) {
        this.casePer10k = casePer10k;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getOnlyCovidDeaths() {
        return onlyCovidDeaths;
    }

    public void setOnlyCovidDeaths(int onlyCovidDeaths) {
        this.onlyCovidDeaths = onlyCovidDeaths;
    }

    public int getDeathsCovidAndCommon() {
        return deathsCovidAndCommon;
    }

    public void setDeathsCovidAndCommon(int deathsCovidAndCommon) {
        this.deathsCovidAndCommon = deathsCovidAndCommon;
    }

    public int getCommissioningPOZ() {
        return commissioningPOZ;
    }

    public void setCommissioningPOZ(int commissioningPOZ) {
        this.commissioningPOZ = commissioningPOZ;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getInvolvedInQuarantine() {
        return involvedInQuarantine;
    }

    public void setInvolvedInQuarantine(int involvedInQuarantine) {
        this.involvedInQuarantine = involvedInQuarantine;
    }

    public int getTestsCount() {
        return testsCount;
    }

    public void setTestsCount(int testsCount) {
        this.testsCount = testsCount;
    }

    public int getPositiveTests() {
        return positiveTests;
    }

    public void setPositiveTests(int positiveTests) {
        this.positiveTests = positiveTests;
    }

    public int getNegativeTests() {
        return negativeTests;
    }

    public void setNegativeTests(int negativeTests) {
        this.negativeTests = negativeTests;
    }

    public int getOtherTests() {
        return otherTests;
    }

    public void setOtherTests(int otherTests) {
        this.otherTests = otherTests;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

}
