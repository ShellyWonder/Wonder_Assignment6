package com.wonderwebdev.services;

import com.wonderwebdev.domain.SalesRecord;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CSVReaderService {

	public List<SalesRecord> readRecordsFromFile(Path path) throws IOException {
	    List<SalesRecord> records = new ArrayList<>();
	    try {
	        List<String> data = Files.readAllLines(path);
	        data.remove(0); // Remove header

	        for (String lineOfData : data) {
	            String[] recordData = lineOfData.split(",");
	            if (recordData.length == 2) {
	                try {
	                    LocalDate date = parseDate(recordData[0]);
	                    SalesRecord record = new SalesRecord(date, Integer.parseInt(recordData[1]));
	                    records.add(record);
	                } catch (DateTimeParseException e) {
	                    System.out.println("Error parsing date for record: " + lineOfData);
	                    e.printStackTrace();
	                } catch (NumberFormatException e) {
	                    System.out.println("Error parsing sales data for record: " + lineOfData);
	                    e.printStackTrace();
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Program cannot read the file.");
	        e.printStackTrace();
	    }
	    return records;
	}


	public LocalDate parseDate(String date) throws DateTimeParseException {
	    String[] formats = {"yyyy-MM-dd", "dd/MM/yyyy", "MMM-yy"};
	    for (String format : formats) {
	        try {
	            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
	            if (format.equals("MMM-yy")) {
	                YearMonth yearMonth = YearMonth.parse(date, dateTimeFormatter);
	                return yearMonth.atDay(1);
	            }
	            return LocalDate.parse(date, dateTimeFormatter);
	        } catch (DateTimeParseException e) {
	            // Ignore and try the next format
	        }
	    }
	    throw new DateTimeParseException("Invalid date format: " + date, date, 0);
	}

}
