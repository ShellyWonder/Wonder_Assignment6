package com.wonderwevbdev;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.wonderwebdev.domain.SalesRecord;
import com.wonderwebdev.services.CSVReaderService;
import com.wonderwebdev.services.SalesAnalyzerService;
import com.wonderwebdev.services.SalesReportGeneratorService;

import java.io.IOException;
import java.nio.file.Paths;

public class YearlyComparisonSalesReportApp {

	public static void main(String[] args) throws IOException {
		CSVReaderService readerService = new CSVReaderService();
		List<SalesRecord> model3Sales = readerService.readRecordsFromFile(Paths.get("model3.csv"));
        List<SalesRecord> modelSSales = readerService.readRecordsFromFile(Paths.get("modelS.csv"));
        List<SalesRecord> modelXSales = readerService.readRecordsFromFile(Paths.get("modelX.csv"));
        
        processSalesData("Model 3", model3Sales);
        processSalesData("Model S", modelSSales);
        processSalesData("Model X", modelXSales);
    }

    public static void processSalesData(String modelName, List<SalesRecord> records) {
        Map<Integer, Integer> yearlySales = SalesAnalyzerService.getYearlySales(records);
        Optional<SalesRecord> bestMonth = SalesAnalyzerService.getBestMonth(records);
        Optional<SalesRecord> worstMonth = SalesAnalyzerService.getWorstMonth(records);

		
        bestMonth.ifPresent(bMonth -> worstMonth.ifPresent(wMonth ->
        SalesReportGeneratorService.printBestAndWorstMonth(modelName, bMonth, wMonth)
    ));
		 
    }
}
