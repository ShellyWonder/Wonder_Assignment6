package com.wonderwebdev.services;

import com.wonderwebdev.domain.SalesRecord;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.nio.file.Path;

public class CSVReaderService {
    public static Optional<List<SalesRecord>> readCSV(Path path) {
        List<SalesRecord> records = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM");
        
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    Date date = sdf.parse(values[0]);
                    int sales = Integer.parseInt(values[1]);
                    records.add(new SalesRecord(outputFormat.format(date), sales));
                } catch (ParseException | NumberFormatException e) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
            return Optional.of(records);
        } catch (IOException e) {
            System.err.println("Failed to read the CSV file: " + e.getMessage());
            return Optional.empty();
        }
    }
}








	
