package pl.pja.jaz_s32362_nbp.query.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Query ID", example = "69")
    private int id;
    @Schema(description = "Currency of exchange rate (always relative to PLN)", example = "chf")
    private String currency;
    @Schema(description = "Starting date (inclusive)", example = "2022-01-01")
    private LocalDate startDate;
    @Schema(description = "Final date (inclusive)", example = "2022-06-11")
    private LocalDate endDate;
    @Schema(description = "Average exchange rate", example = "4.481597321428573")
    private double averageRate;
    @Schema(description = "Time at which the query has been processed", example = "2025-06-21T13:49:35.8783409")
    private LocalDateTime queryTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double rate) {
        this.averageRate = rate;
    }

    public LocalDateTime getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(LocalDateTime queryTime) {
        this.queryTime = queryTime;
    }
}
