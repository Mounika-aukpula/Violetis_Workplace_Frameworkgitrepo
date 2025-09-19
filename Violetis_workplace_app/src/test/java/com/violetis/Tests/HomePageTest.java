package com.violetis.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.violetis.Pages.HomePage;
import com.violetis.Base.BaseTest;

import java.util.List;
import java.util.function.Consumer;
public class HomePageTest extends BaseTest{
	/**
     * Generic validator for submenus
     */
    private void validateSubMenus(
            List<String> subMenus,
            List<String> hrefs,
            String menuType,
            Consumer<String> clickAction) {

        for (int i = 0; i < subMenus.size(); i++) {
            String submenu = subMenus.get(i);
            String expectedHref = hrefs.get(i);

            log.info("Validating {} submenu: {} | Expected Href: {}", menuType, submenu, expectedHref);

            // Click submenu
            clickAction.accept(submenu);

            // Get actual URL
            String currentUrl = driver.getCurrentUrl();
            log.info("Navigated to URL: {}", currentUrl);

            // Validation
            Assert.assertTrue(
                    currentUrl.startsWith(expectedHref) || currentUrl.contains(expectedHref),
                    menuType + " → Submenu: " + submenu +
                            " | Expected href: " + expectedHref +
                            " | Actual: " + currentUrl
            );
            log.info("Validation successful for {} submenu: {}", menuType, submenu);

            // Navigate back
            driver.navigate().back();
            log.info("Navigated back to Home page.");
        }
    }

    @Test(priority = 1)
    public void testHRSubMenus() {
        HomePage home = new HomePage(driver);
        validateSubMenus(
                home.getHRSubMenus(),
                home.getHRSubMenuHrefs(),
                "HR",
                submenu -> home.clickHRSubMenu(submenu)
        );
    }

    @Test(priority = 2)
    public void testCRMSubMenus() {
        HomePage home = new HomePage(driver);
        validateSubMenus(
                home.getCRMSubMenus(),
                home.getCRMSubMenuHrefs(),
                "CRM",
                submenu -> home.clickCRMSubMenu(submenu)
        );
    }

    @Test(priority = 3)
    public void testMailSubMenus() {
        HomePage home = new HomePage(driver);
        validateSubMenus(
                home.getMailSubMenus(),
                home.getMailSubMenuHrefs(),
                "Mail",
                submenu -> home.clickMailSubMenu(submenu)
        );
    }
}
