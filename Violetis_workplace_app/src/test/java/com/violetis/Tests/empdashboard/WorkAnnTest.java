package com.violetis.Tests.empdashboard;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.WorkAnniversaryPage;

public class WorkAnnTest extends BaseTest {
	private WorkAnniversaryPage anniversaryPage;

    @BeforeClass
    public void setup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        anniversaryPage = new WorkAnniversaryPage(driver);
    }
    @Test(priority = 1, description = "Verify anniversaries are displayed")
    public void verifyAnniversariesDisplayed() {
        boolean displayed = anniversaryPage.areAnniversariesDisplayed();
        Assert.assertTrue(displayed, "❌ No anniversaries are displayed on the page!");
        System.out.println("✅ Anniversaries are displayed successfully.");
    }
    @Test(priority = 2, description = "Verify filtering by user")
    public void verifyFilteringByUser() throws InterruptedException {
        String userName = "Testname"; // Example
        anniversaryPage.filterByUser(userName);
        List<WebElement> userNames = anniversaryPage.getDisplayedUserNames();

        Assert.assertTrue(userNames.size() > 0, "❌ No anniversaries found for user: " + userName);

        for (WebElement user : userNames) {
            String displayedUser = user.getText().trim();
            Assert.assertEquals(displayedUser, userName, "❌ Wrong user displayed: " + displayedUser);
        }
        System.out.println("✅ Filtering by user works correctly for: " + userName);
    }
    @Test(priority = 3, description = "Verify filtering by date")
    public void verifyFilteringByDate() {
        String targetDate = "on 5th November";
        anniversaryPage.filterBydatepicker("Nov","2025","5");
        List<WebElement> anniversaryDates = anniversaryPage.getDisplayedAnniversaryDates();

        Assert.assertTrue(anniversaryDates.size() > 0, "❌ No anniversaries found for date: " + targetDate);

        for (WebElement dateElement : anniversaryDates) {
            String displayedDate = dateElement.getText().trim();
            Assert.assertTrue(displayedDate.contains("5th") || displayedDate.contains("November"),
                    "❌ Anniversary date mismatch: " + displayedDate);
        }
        System.out.println("✅ Filtering by date works correctly for: " + targetDate);
    }
    @Test(priority = 4, description = "Verify anniversary milestone badge")
    public void verifyAnniversaryMilestoneBadge() {
        boolean badgeDisplayed = anniversaryPage.isMilestoneBadgeDisplayed();
        Assert.assertTrue(badgeDisplayed, "❌ Milestone badge not displayed!");
    }
}
