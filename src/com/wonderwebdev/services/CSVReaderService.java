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

public class CSVReaderService {
	public List<SalesRecord> readRecordsFromFile(Path path) throws IOException {
		List<SalesRecord> records = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	try {		
	
		List<String> data = Files.readAllLines(path);
		data.remove(0);	
		data.forEach(lineOfData -> {
            String[] recordData = lineOfData.split(",");
            if (recordData.length == 2) {
                try {
                	YearMonth yearMonth = YearMonth.from(LocalDate.parse(recordData[0], formatter));
                    SalesRecord record = new SalesRecord(yearMonth, Integer.parseInt(recordData[1]));
                    records.add(record);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing sales data for record: " + lineOfData);
                    e.printStackTrace();
                }
            }
        });
    } catch (IOException e) {
        System.out.println("Program cannot read the file.");
        e.printStackTrace();
    }

    return records;
}
}
