package com.wonderwebdev.domain;

import java.time.LocalDate;

public class SalesRecord {

	private LocalDate date;
	private int sales;

	public SalesRecord(LocalDate date, int sales) {
		super();

		this.date = date;
		this.sales = sales;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

}
