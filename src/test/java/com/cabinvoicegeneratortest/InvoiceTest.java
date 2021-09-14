package com.cabinvoicegeneratortest;

import org.junit.Test;

import com.cabinvoicegenerator.CalculateInvoice;
import com.cabinvoicegenerator.InvoiceData;

import org.junit.Assert;

public class InvoiceTest {
	
	public CalculateInvoice calculateInvoice;
	
	@Test
	public void givenData_WhenCalculated_ShouldReturnTotalFare() {
		calculateInvoice = new CalculateInvoice();
		long result = calculateInvoice.calculateTotalFare(new InvoiceData(25,12));
		Assert.assertEquals(267, result);
	}
}
