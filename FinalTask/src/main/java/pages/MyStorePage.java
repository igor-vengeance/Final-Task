package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyStorePage {

    private static final String URL = "http://automationpractice.com/index.php";

    private static final By CONTACT_US_BUTTON = By.xpath(".//*[@id='contact-link']/a");
    private static final By SEARCH_BOX = By.xpath(".//*[@id='search_query_top']");
    private static final By SEARCH_BUTTON = By.xpath(".//*[@id='searchbox']/button");
    private static final By CART_BUTTON = By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a/b");
    private static final By T_SHIRTS_BUTTON = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    private static final By SIGN_IN_BUTTON = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");

    private final WebDriver driver;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void load() {driver.get(URL);}

    public ContactUsPage contactUsClick() {
        driver.findElement(CONTACT_US_BUTTON).click();
        return new ContactUsPage(driver);
    }

    public OrderPage orderPageClick() {
        driver.findElement(CART_BUTTON).click();
        return new OrderPage(driver);
    }

    public TShirtsPage tShirtsPageClick() {
        driver.findElement(T_SHIRTS_BUTTON).click();
        return new TShirtsPage(driver);
    }

    public SearchPage search(String keyword) {
        driver.findElement(SEARCH_BOX).sendKeys(keyword);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }

    public LoginPage loginPageClick() {
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }
}
