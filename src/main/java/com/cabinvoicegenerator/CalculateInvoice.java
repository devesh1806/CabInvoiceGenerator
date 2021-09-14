package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateInvoice {

	private Double fare = 0.0;
    private final Integer ratePerKm = 10;
    private final Integer ratePerMin = 1;

	public static List<InvoiceData> totalRides = new ArrayList<>();
    public static Map<Integer,InvoiceService> invoiceDetails = new HashMap<>();
	
    public void addToListRides(InvoiceData invoiceData) {
    	totalRides.add(invoiceData);
    }
    
	public Double calculateTotalFare(InvoiceData invoiceData) {
		fare += (invoiceData.kiloMeters*ratePerKm) + (invoiceData.time*ratePerMin);
		return fare;
	}

	public Double calculateMultipleRidesFare(List<InvoiceData> totalRides) {
		totalRides.stream().forEach(n->{
			fare = calculateTotalFare(n);
		});
		return Math.round(fare*100.0)/100.0;
	}
	
	public Integer totalRidesCount(List<InvoiceData> totalRides) {
		return totalRides.size();
	}
	
	public List<InvoiceData> getList(){
		return totalRides;
	}
	
	public Double avgRideFare(Double fare,List<InvoiceData> totalRides) {
		return Math.round((fare/totalRides.size())*100.0)/100.0;
	}

	public List<InvoiceData> addToListRidesService() {
		List<InvoiceData> arr = new ArrayList<>();
		arr.add(new InvoiceData(43.0,10.0));
		arr.add(new InvoiceData(15.0,15.0));
		arr.add(new InvoiceData(25.8,12.0));
		return arr;
	}

	public void invoiceReturn(List<InvoiceData> arr, Integer id) {
		Double totFare = calculateMultipleRidesFare(arr);
		Double avgFare = avgRideFare(totFare,arr);
		Integer totalCount = totalRidesCount(arr);
		invoiceDetails.put(id, new InvoiceService(totFare, avgFare, totalCount,arr));
	}
	
	public String invoice(Integer id) {
		return invoiceDetails.get(id).toString();
	}
}
