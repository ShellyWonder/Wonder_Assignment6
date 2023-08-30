package com.wonderwebdev.services;

import com.wonderwebdev.domain.SalesRecord;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVReaderService {
	public List<SalesRecord> readRecordsFromFile(Path path) throws IOException {
		List<SalesRecord> records = new ArrayList<>();
	try {		
	
		List<String> data = Files.readAllLines(path);
		data.remove(0);	
		data.forEach(lineOfData -> {
            String[] recordData = lineOfData.split(",");
            if (recordData.length == 2) {
                try {
                    SalesRecord record = new SalesRecord(recordData[0], Integer.parseInt(recordData[1]));
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
