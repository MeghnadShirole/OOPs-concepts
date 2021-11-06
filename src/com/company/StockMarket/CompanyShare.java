package com.company.StockMarket;

public class CompanyShare {
    private final String name;
    private int noOfShare;
    private double sharePrice;

    public CompanyShare(String name, int noOfShare, double sharePrice) {
        super();
        this.name = name;
        this.noOfShare = noOfShare;
        this.sharePrice = sharePrice;
    }

    public int getNoOfShare() {
        return noOfShare;
    }

    public void setNoOfShare(int noOfShare) {
        this.noOfShare = noOfShare;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    @Override
    public String toString() {
        return "CompanyShare [name=" + name + ", noOfShare=" + noOfShare + ", sharePrice=" + sharePrice + "]";
    }
}