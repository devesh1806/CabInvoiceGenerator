package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class CalculateInvoice {

	private Double fare = 0.0;
    private final Integer ratePerKm = 10;
    private final Integer ratePerMin = 1;

	public static List<InvoiceData> totalRides = new ArrayList<>();
    
    public void addToListRides(InvoiceData invoiceData) {
    	totalRides.add(invoiceData);
    }
    
	public Double calculateTotalFare(InvoiceData invoiceData) {
		fare += (invoiceData.kiloMeters*ratePerKm) + (invoiceData.time*ratePerMin);
		return fare;
	}

	public Double calculateMultipleRidesFare() {
		totalRides.stream().forEach(n->{
			fare = calculateTotalFare(n);
		});
		return Math.round(fare*100.0)/100.0;
	}
	
	public Integer totalRidesCount() {
		return totalRides.size();
	}
	
	public Double avgRideFare(Double fare) {
		return Math.round((fare/totalRides.size())*100.0)/100.0;
	}
}
