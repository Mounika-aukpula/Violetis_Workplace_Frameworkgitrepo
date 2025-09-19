package com.violetis.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
public class ExcelUtils {
	private static final Logger log = LogManager.getLogger(ExcelUtils.class);
    private static Workbook workbook;

    // Load Excel file
    public static void loadExcel(String filePath) {
        try {
            log.info("Loading Excel file: {}", filePath);
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            log.info("✅ Excel file loaded successfully.");
        } catch (IOException e) {
            log.error("❌ Failed to load Excel file: {}", filePath, e);
            throw new RuntimeException("Failed to load Excel file: " + filePath, e);
        }
    }

    // Get data from cell
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        try {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                log.error("❌ Sheet '{}' not found in Excel file.", sheetName);
                return null;
            }
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);

            DataFormatter formatter = new DataFormatter();
            String cellValue = formatter.formatCellValue(cell);

            log.debug("Cell Data [Sheet: {}, Row: {}, Col: {}] = {}", sheetName, rowNum, colNum, cellValue);
            return cellValue;
        } catch (Exception e) {
            log.error("❌ Error reading cell data at Sheet: {}, Row: {}, Col: {}", sheetName, rowNum, colNum, e);
            return null;
        }
    }

    // Get row count
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            log.error("❌ Sheet '{}' not found.", sheetName);
            return 0;
        }
        int rowCount = sheet.getPhysicalNumberOfRows();
        log.info("Row count for Sheet '{}': {}", sheetName, rowCount);
        return rowCount;
    }

    // Get column count
    public static int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            log.error("❌ Sheet '{}' not found.", sheetName);
            return 0;
        }
        int colCount = sheet.getRow(0).getLastCellNum();
        log.info("Column count for Sheet '{}': {}", sheetName, colCount);
        return colCount;
    }

    // Close workbook
    public static void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
                log.info("Excel workbook closed.");
            }
        } catch (IOException e) {
            log.error("❌ Error while closing workbook.", e);
        }
    }
}
