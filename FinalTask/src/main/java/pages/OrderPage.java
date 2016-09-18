package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private static final By CART_VOUCHER = By.xpath(".//*[@id='cart_voucher']");
    private static final By DELETE_BUTTON = By.xpath(".//*[@id='2_7_0_0']/i");

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartVoucherDisplayed() {
        WebElement element = null;
        try {
            element = driver.findElement(CART_VOUCHER);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        return element.isDisplayed();
    }

    public void deleteButtonClick() {
        driver.findElement(DELETE_BUTTON).click();
    }

}
