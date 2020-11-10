package com.cdifranco.investingapp.services;

import com.cdifranco.investingapp.models.CompanyScreen;
import com.cdifranco.investingapp.models.HistoricalPrice;

import java.util.List;

public interface StockDataService {
  public List<HistoricalPrice> getPriceRange(String symbol, String startDate, String endDate);

  public List<HistoricalPrice> getTimeSeries(String symbol, int days);

  public List<CompanyScreen> screenCompanies(String searchName, String exchange);
}
