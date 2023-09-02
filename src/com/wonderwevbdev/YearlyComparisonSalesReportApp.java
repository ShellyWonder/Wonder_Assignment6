package com.wonderwevbdev;

import com.wonderwebdev.services.*;
import com.wonderwebdev.domain.SalesRecord;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class YearlyComparisonSalesReportApp {
    public static void main(String[] args) {
        Optional<List<SalesRecord>> optModel3Sales = CSVReaderService.readCSV(Paths.get("model3.csv"));
        Optional<List<SalesRecord>> optModelSSales = CSVReaderService.readCSV(Paths.get("modelS.csv"));
        Optional<List<SalesRecord>> optModelXSales = CSVReaderService.readCSV(Paths.get("modelX.csv"));

        optModel3Sales.ifPresent(records -> processSalesData("Model 3", records));
        optModelSSales.ifPresent(records -> processSalesData("Model S", records));
        optModelXSales.ifPresent(records -> processSalesData("Model X", records));
    }

    public static void processSalesData(String modelName, List<SalesRecord> records) {
        Map<Integer, Integer> yearlySales = SalesAnalyzerService.getYearlySales(records);
        Optional<SalesRecord> bestMonth = SalesAnalyzerService.getBestMonth(records);
        Optional<SalesRecord> worstMonth = SalesAnalyzerService.getWorstMonth(records);

        SalesReportGeneratorService.printYearlyReport(modelName, yearlySales);

        bestMonth.ifPresent(bMonth -> worstMonth.ifPresent(wMonth ->
                SalesReportGeneratorService.printBestAndWorstMonth(modelName, bMonth, wMonth)));
    }
}






