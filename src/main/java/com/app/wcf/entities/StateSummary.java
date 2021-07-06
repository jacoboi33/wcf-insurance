package com.app.wcf.entities;

import java.math.BigDecimal;

public class StateSummary {

    private String state;
    private BigDecimal totalBalance;
    private BigDecimal minBalance;
    private BigDecimal maxBalance;
    private BigDecimal meanBalance;

    public StateSummary(String state, BigDecimal totalBalance, BigDecimal minBalance, BigDecimal maxBalance, BigDecimal meanBalance) {
        this.state = state;
        this.totalBalance = totalBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.meanBalance = meanBalance;
    }

    public StateSummary() { }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }

    public BigDecimal getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(BigDecimal maxBalance) {
        this.maxBalance = maxBalance;
    }

    public BigDecimal getMeanBalance() {
        return meanBalance;
    }

    public void setMeanBalance(BigDecimal meanBalance) {
        this.meanBalance = meanBalance;
    }
}
