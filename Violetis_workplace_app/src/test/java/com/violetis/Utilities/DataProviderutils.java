package com.violetis.Utilities;
import org.testng.annotations.DataProvider;
public class DataProviderutils {
	@DataProvider(name = "signupData")
    public Object[][] getSignupData() {
        String filePath = "src/test/resources/testdata/signuptestdata.xlsx";
        ExcelUtils.loadExcel(filePath);

        int rowCount = ExcelUtils.getRowCount("Sheet1");
        int colCount = ExcelUtils.getColumnCount("Sheet1");

        Object[][] data = new Object[rowCount - 1][colCount]; // exclude header row

        for (int i = 1; i < rowCount; i++) { // start at row 1
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = ExcelUtils.getCellData("Sheet1", i, j);
            }
        }

        ExcelUtils.closeWorkbook();
        return data;
    }
}
