package com.cabinvoicegenerator;

public class CarAgency {

    public Integer normalRatePerKm;
    public Integer normalRatePerMin;
    public Double normalMinimumFare;
    public Integer premiumRatePerKm;
    public Integer premiumRatePerMin;
    public Double premiumMinimumFare;
    
    public CarAgency() {
    	this.normalRatePerKm = 10;
    	this.normalRatePerMin = 1;
    	this.premiumRatePerKm = 15;
    	this.premiumRatePerMin = 2;
    	this.premiumMinimumFare=20.0;
    	this.normalMinimumFare=5.0;
    }
    
}
