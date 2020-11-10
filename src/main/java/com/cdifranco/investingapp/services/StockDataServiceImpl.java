package com.cdifranco.investingapp.services;


import com.cdifranco.investingapp.models.CompanyScreen;
import com.cdifranco.investingapp.models.HistoricalPrice;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StockDataServiceImpl implements StockDataService {

  private String baseUrl = "https://financialmodelingprep.com/api/v3/";
  private String apiKey = "e138480f4ea6e16f584725f6f8568a2c";

  public List<HistoricalPrice> getPriceRange(String symbol, String startDate, String endDate) {
    WebClient webClient = WebClient.create(baseUrl);

    //https://financialmodelingprep.com/api/v3/historical-price-full/AAPL?from=2020-03-12&to=2020-03-12&apikey=e138480f4ea6e16f584725f6f8568a2c

    List<HistoricalPrice> prices = webClient.get()
        .uri("/historical-price-full/{symbol}?from={startDate}&to={endDate}&apikey={apiKey}",
             symbol,
             startDate,
             endDate,
             apiKey)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(HistoricalPrice.class)
        .collectList()
        .block();

    return prices;
  }

  //https://financialmodelingprep.com/api/v3/historical-price-full/AAPL?timeseries={days}apikey=e138480f4ea6e16f584725f6f8568a2c
  public List<HistoricalPrice> getTimeSeries(String symbol, int days){
    WebClient webClient = WebClient.create(baseUrl);

    List<HistoricalPrice> prices = webClient.get()
        .uri("/historical-price-full/{symbol}?timeseries={days}&apikey={apiKey}",
             symbol,
             days,
             apiKey)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(HistoricalPrice.class)
        .collectList()
        .block();

    return prices;
  }

  // https://financialmodelingprep.com/api/v3/search?query=Apple&limit=10&exchange=NASDAQ&apikey=e138480f4ea6e16f584725f6f8568a2c
  @Override
  public List<CompanyScreen> screenCompanies(String searchName,
                                              String exchange) {

    WebClient webClient = WebClient.create(baseUrl);

    List<CompanyScreen> companyScreenList = webClient.get()
        .uri("/search?query={searchName}&limit=10&exchange={exchange}&apikey={apiKey}",
             searchName,
             exchange,
             apiKey)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(CompanyScreen.class)
        .collectList()
        .block();

    return companyScreenList;
  }
}

