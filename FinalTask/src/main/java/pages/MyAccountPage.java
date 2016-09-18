package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private static final By SIGN_OUT_BUTTON = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[2]/a");

    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignOutButtonDisplayed() {
        WebElement element = null;
        try {
            element = driver.findElement(SIGN_OUT_BUTTON);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        return element.isDisplayed();
    }

}
