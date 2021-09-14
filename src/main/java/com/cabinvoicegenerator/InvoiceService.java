package com.cabinvoicegenerator;

import java.util.List;

public class InvoiceService {
	
	public Double totalFare;
	public Double avgFare;
	public Integer totalCount;
	public List<InvoiceData> arr;
	
	public InvoiceService(Double totalFare,Double avgFare,Integer totalCount,List<InvoiceData> arr) {
		this.totalFare=totalFare;
		this.avgFare=avgFare;
		this.totalCount=totalCount;
		this.arr = arr;
	}
	
	@Override
	public String toString() {
		return "Total Fare = " + totalFare+",\nAverage Fare = "+avgFare+",\nTotal Rides = "+totalCount;
	}
}
