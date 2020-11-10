package com.cdifranco.investingapp.models;

/*
      "date": "2019-03-12",
      "open": 45.0,
      "high": 45.6675,
      "low": 44.842499,
      "close": 45.227501,
      "adjClose": 44.442513,
      "volume": 129870400,
      "unadjustedVolume": 129870400,
      "change": 0.2275,
      "changePercent": 0.506,
      "vwap": 45.24583,
      "label": "March 12, 19",
      "changeOverTime": 0.00506
 */

import lombok.Data;


@Data
public class HistoricalPrice {
    private String symbol;
    public Historical[] historical;

    public HistoricalPrice(){}

    public HistoricalPrice(String symbol, Historical[] historical) {
        this.symbol = symbol;
        this.historical = historical;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Historical[] getHistorical() {
        return historical;
    }

    public void setHistorical(Historical[] historical) {
        this.historical = historical;
    }
}

@Data
class Historical {
    private String date;
    private double open;
    private double high;
    private double close;
    private double adjClose;
    private long volume;
    private long unadjustedVolume;
    private double change;
    private double changePercent;
    private String label;
    private double changeOverTime;

    public Historical(){}

    public Historical(String date, double open, double high, double close, double adjClose, long volume, long unadjustedVolume, double change, double changePercent, String label, double changeOverTime) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public void setUnadjustedVolume(long unadjustedVolume) {
        this.unadjustedVolume = unadjustedVolume;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getChangeOverTime() {
        return changeOverTime;
    }

    public void setChangeOverTime(double changeOverTime) {
        this.changeOverTime = changeOverTime;
    }
}