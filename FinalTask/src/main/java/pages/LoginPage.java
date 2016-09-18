package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private static final By EMAIL_ADDRESS = By.xpath(".//*[@id='email_create']");
    private static final By CREATE_AN_ACCOUNT = By.xpath(".//*[@id='SubmitCreate']");
    private static final By CUSTOMER_FIRST_NAME = By.xpath(".//*[@id='customer_firstname']");
    private static final By CUSTOMER_LAST_NAME = By.xpath(".//*[@id='customer_lastname']");
    private static final By PASSWORD = By.xpath(".//*[@id='passwd']");
    private static final By FIRST_NAME = By.xpath(".//*[@id='firstname']");
    private static final By LAST_NAME = By.xpath(".//*[@id='firstname']");
    private static final By ADDRESS = By.xpath(".//*[@id='address1']");
    private static final By CITY = By.xpath(".//*[@id='city']");
    private static final By STATE = By.xpath(".//*[@id='id_state']/option[2]");
    private static final By POSTAL_CODE = By.xpath(".//*[@id='postcode']");
    private static final By MOBILE_PHONE = By.xpath(".//*[@id='phone_mobile']");
    private static final By REGISTER = By.xpath(".//*[@id='submitAccount']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage createAnAccount(String email, String first, String last, String password, String address, String city, String code, String phone) {
        driver.findElement(EMAIL_ADDRESS).sendKeys(email);
        driver.findElement(CREATE_AN_ACCOUNT).click();
        driver.findElement(CUSTOMER_FIRST_NAME).sendKeys(first);
        driver.findElement(CUSTOMER_LAST_NAME).sendKeys(last);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(FIRST_NAME).sendKeys(first);
        driver.findElement(LAST_NAME).sendKeys(last);
        driver.findElement(ADDRESS).sendKeys(address);
        driver.findElement(CITY).sendKeys(city);
        driver.findElement(STATE).click();
        driver.findElement(POSTAL_CODE).sendKeys(code);
        driver.findElement(MOBILE_PHONE).sendKeys(phone);
        driver.findElement(REGISTER).click();
        return new MyAccountPage(driver);
    }

}
