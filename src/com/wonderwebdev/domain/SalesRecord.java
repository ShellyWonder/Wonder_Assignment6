package com.wonderwebdev.domain;

public class SalesRecord {
private String modelName;
private String date;
private int sales;

public SalesRecord(String modelName, String date, int sales) {
	super();
	this.modelName = modelName;
	this.date = date;
	this.sales = sales;
}

public String getModelName() {
	return modelName;
}

public void setModelName(String modelName) {
	this.modelName = modelName;
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
