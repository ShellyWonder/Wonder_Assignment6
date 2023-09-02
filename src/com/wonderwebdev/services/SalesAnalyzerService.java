package com.wonderwebdev.services;

import java.util.*;
import java.util.stream.*;

import com.wonderwebdev.domain.SalesRecord;

public class SalesAnalyzerService {

	public static Map<Integer, Integer> getYearlySales(List<SalesRecord> records) {
		return records.stream()
				.collect(Collectors.groupingBy(record -> Integer.parseInt(record.getDate().split("-")[0]),
						Collectors.summingInt(SalesRecord::getSales)));
	}

	public static Optional<SalesRecord> getBestMonth(List<SalesRecord> records) {
		return records.stream().max(Comparator.comparingInt(SalesRecord::getSales));
	}

	public static Optional<SalesRecord> getWorstMonth(List<SalesRecord> records) {
		return records.stream().min(Comparator.comparingInt(SalesRecord::getSales));
	}
}