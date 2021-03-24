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
    @CsvBindByPosition(position = 0)
    private String province;
    @Column
    @CsvBindByPosition(position = 1)
    private String county;
    @Column(name = "case_count")
    @CsvBindByPosition(position = 2)
    private int caseCount;
    @Column(name = "case_per_10k")
    @CsvBindByPosition(position = 3)
    private float casePer10k;
    @Column
    @CsvBindByPosition(position = 4)
    private int deaths;
    @Column(name = "only_covid_deaths")
    @CsvBindByPosition(position = 5)
    private int onlyCovidDeaths;
    @CsvBindByPosition(position = 6)
    @Column(name = "deaths_covid_and_common")
    private int deathsCovidAndCommon;
    @CsvBindByPosition(position = 7)
    @Column(name = "commissioning_POZ")
    private int commissioningPOZ;
    @CsvBindByPosition(position = 8)
    @Column
    private int recovered;
    @CsvBindByPosition(position = 9)
    @Column(name = "involved_in_quarantine")
    private int involvedInQuarantine;
    @CsvBindByPosition(position = 10)
    @Column(name = "tests_count")
    private int testsCount;
    @CsvBindByPosition(position = 11)
    @Column(name = "positive_tests")
    private int positiveTests;
    @CsvBindByPosition(position = 12)
    @Column(name = "negative_tests")
    private int negativeTests;
    @CsvBindByPosition(position = 13)
    @Column(name = "other_tests")
    private int otherTests;
    @CsvBindByPosition(position = 14)
    @Column
    private String territory;
    @CsvBindByPosition(position = 15)
    @Column(name = "actual_date")
    private String actualDate;
    @ManyToOne
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
