package com.wonderwebdev.services;

import java.util.*;

import com.wonderwebdev.domain.SalesRecord;

public class SalesReportGeneratorService {

    public static void printYearlyReport(String modelName, Map<Integer, Integer> yearlySales) {
    	System.out.println("---------------------------");
        System.out.println(modelName + " Yearly Sales Report");
        System.out.println("---------------------------");
        yearlySales.forEach((year, sales) -> {
            System.out.println(year + " -> " + sales);
        });
    }

    public static void printBestAndWorstMonth(String modelName, SalesRecord bestMonth, SalesRecord worstMonth) {
        System.out.println("\nThe best month for " + modelName + " was: " + bestMonth.getDate());
        System.out.println("The worst month for " + modelName + " was: " + worstMonth.getDate());
    }
}
