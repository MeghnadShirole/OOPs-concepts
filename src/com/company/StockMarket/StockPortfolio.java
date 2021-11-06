package com.company.StockMarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StockPortfolio {

    private List<Stock> stocks;
    private Map<String, Double> stockMap;
    private double totalStockVal;

    public StockPortfolio() {
        stocks = new ArrayList<>();
        stockMap = new HashMap<>();
    }

    private double calculateValueForStock(Stock stock) {
        return stock.getNoOfShare() * stock.getSharePrice();
    }

    public void addStock(String stockName, int noOfShares, double sharePrice) {

        Stock newStock = new Stock(stockName, noOfShares, sharePrice);
        stocks.add(newStock);
        double stockVal = this.calculateValueForStock(newStock);
        totalStockVal += stockVal;
        stockMap.put(stockName, stockVal);

    }

    public void removeStock(String stockName, int noOfShares, double sharePrice) {

        Stock newStock = new Stock(stockName, noOfShares, sharePrice);
        stocks.remove(newStock);
        double stockVal = this.calculateValueForStock(newStock);
        totalStockVal -= stockVal;
        stockMap.put(stockName, stockVal);

    }

    public void printReport() {
        for(Entry<String, Double> entry : stockMap.entrySet()) {
            System.out.println("The company : " + entry.getKey() + " Stock Value : " + entry.getValue());
        }
        System.out.println("Stock Total Value : " + totalStockVal);
    }

    public double getTotalStockVal () {
        return this.totalStockVal;
    }
}
