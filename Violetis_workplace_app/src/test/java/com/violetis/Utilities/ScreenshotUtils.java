package com.violetis.Utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
public class ScreenshotUtils {
	 public static String takeScreenshot(WebDriver driver, String testName) {
	        // Timestamp for unique file names
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        // Capture screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // Save location
	        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

	        try {
	            FileUtils.copyFile(src, new File(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path; // Return path for Extent Report
	    }
}
