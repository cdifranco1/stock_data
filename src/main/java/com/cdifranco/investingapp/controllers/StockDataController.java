package com.cdifranco.investingapp.controllers;

import com.cdifranco.investingapp.models.CompanyScreen;
import com.cdifranco.investingapp.models.HistoricalPrice;
import com.cdifranco.investingapp.services.StockDataService;
import com.cdifranco.investingapp.services.StockDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockDataController {
  @Autowired
  StockDataService stockDataService;

  // http://localhost:8090/prices/twtr?startdate=2019-11-20&enddate=2019-11-30
  @GetMapping(path = "/prices/{symbol}")
  public ResponseEntity<?> priceRange(@PathVariable("symbol") String symbol,
                                @RequestParam(value = "startdate") String startDate,
                                @RequestParam(value = "enddate") String endDate){

    List<HistoricalPrice> response = stockDataService.getPriceRange(symbol, startDate, endDate);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  // http://localhost:8090/prices/all/twtr
  @GetMapping(path = "/timeseries/{symbol}")
  public ResponseEntity<?> allPrices(@PathVariable("symbol") String symbol, @RequestParam("days") int days){
    List<HistoricalPrice> response = stockDataService.getTimeSeries(symbol, days);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  // stock ticker search
  // http://localhost:8090/search?query=twitter&limit=10&exchange=NASDAQ
  @GetMapping(path = "/search")
  public ResponseEntity<?> screenCompanies(@RequestParam("query") String companyName,
                                       @RequestParam("exchange") String exchange){

    List<CompanyScreen> companyScreens = stockDataService.screenCompanies(companyName, exchange);

    return new ResponseEntity<>(companyScreens, HttpStatus.OK);
  }





}
