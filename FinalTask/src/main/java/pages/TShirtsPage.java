package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TShirtsPage {

    private static final By T_SHIRT_IMAGE = By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");

    private final WebDriver driver;

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTShirtsDisplayed() {
        WebElement element = null;
        try {
            element = driver.findElement(T_SHIRT_IMAGE);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        return element.isDisplayed();
    }
}
