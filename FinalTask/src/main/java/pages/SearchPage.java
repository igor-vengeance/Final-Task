package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private static final By ITEM_IMAGE = By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
    private static final By VIEW_LIST = By.xpath(".//*[@id='list']/a");
    private static final By ADD_TO_CART = By.xpath(".//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[1]/span");
    private static final By PROCEED_TO_CHECKOUT = By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchItemDisplayed() {
        WebElement element = null;
        try {
            element = driver.findElement(ITEM_IMAGE);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        return element.isDisplayed();
    }

    public void ViewListClick() {
        driver.findElement(VIEW_LIST).click();
    }

    public void addToCartClick() { driver.findElement(ADD_TO_CART).click(); }

    public OrderPage proceedToCheckoutClick() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        return new OrderPage(driver);
    }

}
