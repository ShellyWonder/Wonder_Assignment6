package com.wonderwebdev.domain;

public class SalesRecord {

	private String date;
	private int sales;

	public SalesRecord(String date, int sales) {
		super();

		this.date = date;
		this.sales = sales;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

}
