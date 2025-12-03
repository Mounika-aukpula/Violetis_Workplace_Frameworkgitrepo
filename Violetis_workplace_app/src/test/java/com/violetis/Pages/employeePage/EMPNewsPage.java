package com.violetis.Pages.employeePage;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EmpNewsLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPNewsPage extends BasePage {

	public EMPNewsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetonewspage() {
		WaitUtils.waitForElementClickable(driver, EmpNewsLocators.Newsbtn, 20).click();
	}
	//-----------------------------------------
    // SEARCH
    //-----------------------------------------
    public void searchNews(String text) {
        WebElement search = WaitUtils.waitForElementClickable(driver, EmpNewsLocators.searchnewsinputbox, 20);
        search.clear();
        search.sendKeys(text);
    }

    public boolean isEmptyStateDisplayed() {
        return driver.findElements(EmpNewsLocators.nodataele).size() > 0;
    }
    //-----------------------------------------
    // TABLE VALIDATIONS
    //-----------------------------------------
    public boolean areHeadersCorrect() {
        List<String> headers =WaitUtils.waitForElementsVisible(driver, EmpNewsLocators.headernames, 20).stream().map(WebElement::getText).map(String::trim)
                .collect(Collectors.toList());

        return headers.size() == 2 &&
                headers.contains("Title") &&
                headers.contains("Action");
    }
    public List<String> getAllTitles() {
        return driver.findElements(EmpNewsLocators.alltitles)
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public boolean isViewIconPresent() {
        return driver.findElements(EmpNewsLocators.viewicons).size() > 0;
    }
    //-----------------------------------------
    // ACTION COLUMN
    //-----------------------------------------
    public void clickViewIcon(int rowIndex) {
        driver.findElements(EmpNewsLocators.viewicons).get(rowIndex).click();
    }
    public boolean isColumnHeaderDisplayed(String columnName) {
        List<WebElement> headers = WaitUtils.waitForElementsVisible(driver, EmpNewsLocators.headernames, 20);

        for (WebElement header : headers) {
            String headerText = header.getText().trim();
            if (headerText.equalsIgnoreCase(columnName)) {
                return header.isDisplayed();
            }
        }
        return false; // Header not found
    }
    public String gettitlefromviewpage() {
    	WebElement title=WaitUtils.waitForElementVisible(driver, EmpNewsLocators.viewbtntitle, 20);
    	String acttitle=title.getText();
    	return acttitle;
    }
    public String gettitle(int rowIndex) {
    	String act_title=driver.findElements(EmpNewsLocators.viewicons).get(rowIndex).getText();
    	return act_title;
    }
}
