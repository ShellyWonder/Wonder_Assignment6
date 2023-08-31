package com.wonderwebdev.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Comparator;

import java.time.YearMonth;

import com.wonderwebdev.domain.SalesRecord;

public class SalesAnalyzerService {
	
	public static Map<YearMonth, Integer> getYearlySales(List<SalesRecord> records) {
        return records.stream()
        		.collect(Collectors.groupingBy(SalesRecord::getDate, Collectors.summingInt(SalesRecord::getSales)));
    }

	public static Optional<SalesRecord> getBestMonth(List<SalesRecord> records) {
	    return Optional.ofNullable(records.stream()
	            .max(Comparator.comparingInt(SalesRecord::getSales))
	            .orElse(null));
	}

	public static Optional<SalesRecord> getWorstMonth(List<SalesRecord> records) {
	    return Optional.ofNullable(records.stream()
	            .min(Comparator.comparingInt(SalesRecord::getSales))
	            .orElse(null));
	}
}
