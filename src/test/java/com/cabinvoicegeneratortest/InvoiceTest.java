package com.cabinvoicegeneratortest;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.cabinvoicegenerator.CalculateInvoice;
import com.cabinvoicegenerator.InvoiceData;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceTest {
	
	public CalculateInvoice calculateInvoice;
	
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
		Double result = calculateInvoice.calculateTotalFare(new InvoiceData(25.0,12.0));
		if (result<5.0) result = 5.0;
		Assert.assertEquals((Double)262.0, result);
	}
	
	@Test
	public void givenLessDistanceData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		Double result = calculateInvoice.calculateTotalFare(new InvoiceData(0.1,2.0));
		if (result<5.0) result = 5.0;
		Assert.assertEquals((Double)5.0, result);
	}
	
	
	
	@Test
	public void givenMultipleData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		Double result = calculateInvoice.calculateMultipleRidesFare();
		Assert.assertEquals((Double)1218.9, result);
	}
	
	@Test
	public void givenMultipleData_WhenCalculated_ShouldReturnTotalAverageFareAndTotalRides() {
		calculateInvoice = new CalculateInvoice();
		Double result = calculateInvoice.calculateMultipleRidesFare();
		if (result<5.0) result = 5.0;
		Integer resultCount = calculateInvoice.totalRidesCount();
		Double resultAvg = calculateInvoice.avgRideFare(result);
		Assert.assertEquals((Double)1218.9, result);
		Assert.assertEquals((Integer)6, resultCount);
		System.out.println(resultAvg);
		Assert.assertEquals((Double)203.15, resultAvg);
	}
}
