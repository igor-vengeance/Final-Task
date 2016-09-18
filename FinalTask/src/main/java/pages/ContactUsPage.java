package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    private static final By CUSTOMER_SERVICE = By.xpath(".//*[@id='id_contact']/option[2]");
    private static final By EMAIL_ADDRESS = By.xpath(".//*[@id='email']");
    private static final By ORDER_REFERENCE = By.xpath(".//*[@id='id_order']");
    private static final By ATTACH_FILE = By.xpath(".//*[@id='fileUpload']");
    private static final By MESSAGE_BOX = By.xpath(".//*[@id='message']");
    private static final By SEND_BUTTON = By.xpath(".//*[@id='submitMessage']");
    private static final By SUCCESS_MESSAGE = By.xpath(".//*[@id='center_column']/p");
    private static final By ERROR_MESSAGE = By.xpath(".//*[@id='center_column']/div/ol/li");

    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void contactUs(String email, String order, String file, String message) {
        driver.findElement(CUSTOMER_SERVICE).click();
        driver.findElement(EMAIL_ADDRESS).sendKeys(email);
        driver.findElement(ORDER_REFERENCE).sendKeys(order);
        driver.findElement(ATTACH_FILE).sendKeys(file);
        driver.findElement(MESSAGE_BOX).sendKeys(message);
        driver.findElement(SEND_BUTTON).click();
    }

    public String getSuccessMessageText() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
