package com.company.StockMarket;

public class StockAccount {
    private final String customerName;

    private double balance;

    private final StockPortfolio stockPortfolio;

    public StockAccount(String customerName, double balance) {
        super();
        this.customerName = customerName;
        this.balance = balance;
        this.stockPortfolio = new StockPortfolio();
    }

    public void debit(double money) {

        if(money > balance) {
            System.out.println("Debit amount exceeded account balance.");
        }
        else {
            balance = balance - money;
        }
    }

    public void buy(int noOfShares, String company) {

        double sharePrice = StockInventory.priceOfShareByCompany(company);
        double amount = sharePrice * noOfShares;
        boolean result;

        if(amount <= balance) {
            result = StockInventory.buy(company, noOfShares);
        }

        else{
            System.out.println("You do not have sufficient balance to buy the share.");
            return;
        }

        if(result) {
            this.debit(amount);
            stockPortfolio.addStock(company, noOfShares, sharePrice);
        }

    }

    public void sell(int noOfShares, String company) {
        double sharePrice = StockInventory.priceOfShareByCompany(company);
        double amount = sharePrice * noOfShares;
        boolean result;

        result = StockInventory.sell(company, noOfShares);

        if(result) {
            this.credit(amount);
            stockPortfolio.removeStock(company, noOfShares, sharePrice);
        }
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void printReport() {
        System.out.println("The Stock Report for the customer : " + customerName);

        double totalBalance = stockPortfolio.getTotalStockVal() + this.balance;
        System.out.println("User Total amount  : " + totalBalance);

        stockPortfolio.printReport();
        System.out.println("User Account balance  : " + this.balance);
    }
}