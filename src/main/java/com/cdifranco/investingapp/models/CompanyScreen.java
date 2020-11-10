package com.cdifranco.investingapp.models;


import lombok.Data;

@Data
public class CompanyScreen {
  private String symbol;
  private String name;
  private String currency;
  private String stockExchange;
  private String exchangeShortName;

  public CompanyScreen() {
  }

  public CompanyScreen(String symbol, String name, String currency,
                       String stockExchange, String exchangeShortName) {
    this.symbol = symbol;
    this.name = name;
    this.currency = currency;
    this.stockExchange = stockExchange;
    this.exchangeShortName = exchangeShortName;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getStockExchange() {
    return stockExchange;
  }

  public void setStockExchange(String stockExchange) {
    this.stockExchange = stockExchange;
  }

  public String getExchangeShortName() {
    return exchangeShortName;
  }

  public void setExchangeShortName(String exchangeShortName) {
    this.exchangeShortName = exchangeShortName;
  }
}
