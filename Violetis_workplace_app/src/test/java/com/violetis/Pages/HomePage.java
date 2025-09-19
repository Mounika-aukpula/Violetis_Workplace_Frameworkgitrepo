package com.violetis.Pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.HomePageLocators;
public class HomePage extends BasePage {
	private Actions actions;

    // ===== Constructor =====
    public HomePage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }
    // ====== Hover Helper ======
    private void hover(By menu) {
        WebElement element = getElement(menu);
        actions.moveToElement(element).perform();
        log.info("Hovered over menu: {}", menu);
    }

    // ====== Generic submenu text extractor ======
    private List<String> getSubMenuTexts(By menu, By submenuLocator) {
        hover(menu);
        List<WebElement> submenus = driver.findElements(submenuLocator);
        List<String> texts = new ArrayList<>();
        for (WebElement e : submenus) {
            texts.add(e.getText().trim());
        }
        log.info("Fetched submenu texts: {}", texts);
        return texts;
    }

    // ====== Generic submenu href extractor ======
    private List<String> getSubMenuHrefs(By menu, By submenuLocator) {
        hover(menu);
        List<WebElement> submenus = driver.findElements(submenuLocator);
        List<String> hrefs = new ArrayList<>();
        for (WebElement e : submenus) {
            String href = e.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                hrefs.add(href.trim());
            }
        }
        log.info("Fetched submenu hrefs: {}", hrefs);
        return hrefs;
    }

    // ====== Generic submenu click by text ======
    private void clickSubMenu(By menu, By submenuLocator, String subMenuName) {
        hover(menu);
        List<WebElement> submenus = driver.findElements(submenuLocator);
        for (WebElement e : submenus) {
            if (e.getText().trim().equalsIgnoreCase(subMenuName)) {
                e.click();
                log.info("Clicked submenu: {}", subMenuName);
                break;
            }
        }
    }

    // ===== HR =====
    public List<String> getHRSubMenus() { return getSubMenuTexts(HomePageLocators.HR_FEATURES, HomePageLocators.HR_FEATURE_SUBMENUS); }
    public List<String> getHRSubMenuHrefs() { return getSubMenuHrefs(HomePageLocators.HR_FEATURES, HomePageLocators.HR_FEATURE_SUBMENUS); }
    public void clickHRSubMenu(String subMenuName) { clickSubMenu(HomePageLocators.HR_FEATURES, HomePageLocators.HR_FEATURE_SUBMENUS, subMenuName); }

    // ===== CRM =====
    public List<String> getCRMSubMenus() { return getSubMenuTexts(HomePageLocators.CRM, HomePageLocators.CRM_MENUS); }
    public List<String> getCRMSubMenuHrefs() { return getSubMenuHrefs(HomePageLocators.CRM, HomePageLocators.CRM_MENUS); }
    public void clickCRMSubMenu(String subMenuName) { clickSubMenu(HomePageLocators.CRM, HomePageLocators.CRM_MENUS, subMenuName); }

    // ===== Mail =====
    public List<String> getMailSubMenus() { return getSubMenuTexts(HomePageLocators.MAIL, HomePageLocators.MAIL_MENUS); }
    public List<String> getMailSubMenuHrefs() { return getSubMenuHrefs(HomePageLocators.MAIL, HomePageLocators.MAIL_MENUS); }
    public void clickMailSubMenu(String subMenuName) { clickSubMenu(HomePageLocators.MAIL, HomePageLocators.MAIL_MENUS, subMenuName); }

    // ===== Other Main Menus =====
    public void clickResources() { click(HomePageLocators.RESOURCES); }
    public void clickPartner() { click(HomePageLocators.PARTNER); }
    public void clickPricing() { click(HomePageLocators.PRICING); }
    public void clickLogin() { click(HomePageLocators.LOGIN ); }
}

