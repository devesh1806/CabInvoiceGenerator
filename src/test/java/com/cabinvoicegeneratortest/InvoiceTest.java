package com.cabinvoicegeneratortest;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cabinvoicegenerator.CalculateInvoice;
import com.cabinvoicegenerator.CarAgency;
import com.cabinvoicegenerator.InvoiceData;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceTest {
	
	public CalculateInvoice calculateInvoice;
	public CarAgency carAgency;
	
	@Test
	public void addData_ForMultipleRides() {
		calculateInvoice = new CalculateInvoice();
		calculateInvoice.addToListRides(new InvoiceData(43.0,10.0));
		calculateInvoice.addToListRides(new InvoiceData(15.0,15.0));
		calculateInvoice.addToListRides(new InvoiceData(7.19,10.0));
		calculateInvoice.addToListRides(new InvoiceData(18.0,17.0));
		calculateInvoice.addToListRides(new InvoiceData(5.6,9.0));
		calculateInvoice.addToListRides(new InvoiceData(25.8,12.0));
	}
	
	@Test
	public void givenData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		carAgency = new CarAgency();
		Double result = calculateInvoice.calculateTotalFare(new InvoiceData(25.0,12.0),"normal");
		if (result< carAgency.normalMinimumFare) result = carAgency.normalMinimumFare;
		Assert.assertEquals((Double)262.0, result);
	}
	
	@Test
	public void givenLessDistanceData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		carAgency = new CarAgency();
		Double result = calculateInvoice.calculateTotalFare(new InvoiceData(0.1,2.0),"normal");
		if (result< carAgency.normalMinimumFare) result = carAgency.normalMinimumFare;
		Assert.assertEquals((Double)5.0, result);
	}
	
	
	
	@Test
	public void givenMultipleData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		List<InvoiceData> arr=calculateInvoice.getList();
		Double result = calculateInvoice.calculateMultipleRidesFare(arr,"normal");
		Assert.assertEquals((Double)1218.9, result);
	}
	
	@Test
	public void givenMultipleData_WhenCalculated_ShouldReturnTotalAverageFareAndTotalRides() {
		calculateInvoice = new CalculateInvoice();
		List<InvoiceData> arr=calculateInvoice.getList();
		Double result = calculateInvoice.calculateMultipleRidesFare(arr,"normal");
		Integer resultCount = calculateInvoice.totalRidesCount(arr);
		Double resultAvg = calculateInvoice.avgRideFare(result,arr);
		Assert.assertEquals((Double)1218.9, result);
		Assert.assertEquals((Integer)6, resultCount);
		Assert.assertEquals((Double)203.15, resultAvg);
	}
	
	@Test
	public void givenDataWithId_WhenCalculated_ShouldReturnInvoice() {
		calculateInvoice = new CalculateInvoice();
		carAgency = new CarAgency();
		List<InvoiceData> arr=calculateInvoice.addToListRidesService();
		List<InvoiceData> arrSecond=calculateInvoice.getList();
		calculateInvoice.invoiceReturn(arr,1,"normal");
		calculateInvoice.invoiceReturn(arrSecond,2,"normal");
		String res = calculateInvoice.invoice(1);
		String resSecond = calculateInvoice.invoice(2);
		String resExpected = "Total Fare = 875.0,\nAverage Fare = 291.67,\nTotal Rides = 3";
		String resSecondExpected = "Total Fare = 2093.9,\nAverage Fare = 348.98,\nTotal Rides = 6";
		Assert.assertEquals(resExpected, res);
		Assert.assertEquals(resSecondExpected, resSecond);
	}
	
	@Test
	public void givenDataWithId_WhenPremiumCalculated_ShouldReturnInvoice() {
		calculateInvoice = new CalculateInvoice();
		carAgency = new CarAgency();
		List<InvoiceData> arr=calculateInvoice.addToListRidesService();
		List<InvoiceData> arrSecond=calculateInvoice.getList();
		calculateInvoice.invoiceReturn(arr,1,"premium");
		calculateInvoice.invoiceReturn(arrSecond,2,"premium");
		String res = calculateInvoice.invoice(1);
		String resSecond = calculateInvoice.invoice(2);
		String resExpected = "Total Fare = 1331.0,\nAverage Fare = 443.67,\nTotal Rides = 3";
		String resSecondExpected = "Total Fare = 3195.85,\nAverage Fare = 532.64,\nTotal Rides = 6";
		Assert.assertEquals(resExpected, res);
		Assert.assertEquals(resSecondExpected, resSecond);
	}
	
}
