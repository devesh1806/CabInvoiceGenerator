package com.cabinvoicegenerator;

import java.util.List;

public class CalculateInvoice {

	private Double fare = 5.0;
    private final Integer ratePerKm = 10;
    private final Integer ratePerMin = 1;
    
	public Double calculateTotalFare(InvoiceData invoiceData) {
		fare += (invoiceData.kiloMeters*ratePerKm) + (invoiceData.time*ratePerMin);
		return fare;
	}

	public Double calculateMultipleRidesFare(List<InvoiceData> totalRides) {
		totalRides.stream().forEach(n->{
			fare = calculateTotalFare(n);
		});
		return fare;
	}
}
