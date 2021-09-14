package com.cabinvoicegenerator;

public class CalculateInvoice {

	private long fare = 5;
    private final Integer ratePerKm = 10;
    private final Integer ratePerMin = 1;
    
	public long calculateTotalFare(InvoiceData invoiceData) {
		fare += (long)(invoiceData.kiloMeters*ratePerKm) + (invoiceData.time*ratePerMin);
		return fare;
	}
}
