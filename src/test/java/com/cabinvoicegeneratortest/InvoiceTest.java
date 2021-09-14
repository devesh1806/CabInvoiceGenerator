package com.cabinvoicegeneratortest;

import org.junit.Test;

import com.cabinvoicegenerator.CalculateInvoice;
import com.cabinvoicegenerator.InvoiceData;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceTest {
	
	public CalculateInvoice calculateInvoice;
	List<InvoiceData> totalRides = new ArrayList<>();
	
	@Test
	public void givenData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		Double result = calculateInvoice.calculateTotalFare(new InvoiceData(25.0,12));
		Assert.assertEquals((Double)267.0, result);
	}
	
	@Before
	public void addData_ForMultipleRides() {
		totalRides.add(new InvoiceData(43.0,10));
        totalRides.add(new InvoiceData(15.0,15));
        totalRides.add(new InvoiceData(7.19,10));
        totalRides.add(new InvoiceData(18.0,17));
        totalRides.add(new InvoiceData(5.6,9));
        totalRides.add(new InvoiceData(25.8,12));
	}
	
	@Test
	public void givenMultipleData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		Double result = calculateInvoice.calculateMultipleRidesFare(totalRides);
		Assert.assertEquals((Double)1223.9, result);
	}
}
