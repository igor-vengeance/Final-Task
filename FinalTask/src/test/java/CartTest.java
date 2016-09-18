import helper.Listener;
import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MyStorePage;
import pages.OrderPage;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import webdriver.WebDriverConfiguration;

@Listeners(Listener.class)
public class CartTest {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private SearchPage searchPage;
    private OrderPage orderPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfiguration.setLocalDriver();
        myStorePage = new MyStorePage(driver);
        myStorePage.load();
    }

    @AfterMethod
    public void tearDown() { driver.quit(); }

    @Test
    @TestCaseId("E-5")
    @Features("Cart")
    @Stories("Verify the ability to add and delete items from cart")
    public void cartTest() {
        searchPage = myStorePage.search("blouse");
        searchPage.ViewListClick();
        searchPage.addToCartClick();
        orderPage = searchPage.proceedToCheckoutClick();
        Assert.assertTrue(orderPage.isCartVoucherDisplayed(), "Item is not displayed in the cart!");
        orderPage.deleteButtonClick();
        Assert.assertTrue(Waiter.getWaiter(driver).until(ExpectedConditions.textToBePresentInElement(By.id("center_column"), "Your shopping cart is empty.")));
    }
}
