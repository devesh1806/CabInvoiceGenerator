package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateInvoice {

	private Double fare = 0.0;

	public static List<InvoiceData> totalRides = new ArrayList<>();
    public static Map<Integer,InvoiceService> invoiceDetails = new HashMap<>();
	public CarAgency carAgency = new CarAgency();
    
    
    public void addToListRides(InvoiceData invoiceData) {
    	totalRides.add(invoiceData);
    }
    
	public Double calculateTotalFare(InvoiceData invoiceData,String category) {
		if (category.equals("normal")) {
			fare += (invoiceData.kiloMeters*carAgency.normalRatePerKm) + (invoiceData.time*carAgency.normalRatePerMin);
			return fare;
		}
		else {
			fare += (invoiceData.kiloMeters*carAgency.premiumRatePerKm) + (invoiceData.time*carAgency.premiumRatePerMin);
			return fare;
		}
	}

	public Double calculateMultipleRidesFare(List<InvoiceData> totalRides,String category) {
		totalRides.stream().forEach(n->{
			fare = calculateTotalFare(n,category);
		});
		fare = Math.round(fare*100.0)/100.0;;
		if (category.equals("normal")) {
			if (fare< carAgency.normalMinimumFare) fare = carAgency.normalMinimumFare;
		}
		else {
			if (fare< carAgency.premiumMinimumFare) fare = carAgency.premiumMinimumFare;
		}
		return fare;
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

	public void invoiceReturn(List<InvoiceData> arr, Integer id,String category) {
		Double totFare = calculateMultipleRidesFare(arr,category);
		Double avgFare = avgRideFare(totFare,arr);
		Integer totalCount = totalRidesCount(arr);
		invoiceDetails.put(id, new InvoiceService(totFare, avgFare, totalCount,arr));
	}
	
	public String invoice(Integer id) {
		return invoiceDetails.get(id).toString();
	}
}
