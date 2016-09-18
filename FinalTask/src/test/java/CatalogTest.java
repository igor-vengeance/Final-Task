import helper.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MyStorePage;
import pages.TShirtsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import webdriver.WebDriverConfiguration;

@Listeners(Listener.class)
public class CatalogTest {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private TShirtsPage tShirtsPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfiguration.setLocalDriver();
        myStorePage = new MyStorePage(driver);
        myStorePage.load();
    }

    @AfterMethod
    public void tearDown() { driver.quit(); }

    @Test
    @TestCaseId("E-6")
    @Features("Catalog")
    @Stories("Catalog test")
    public void catalogTest() {
        tShirtsPage = myStorePage.tShirtsPageClick();
        Assert.assertTrue(tShirtsPage.isTShirtsDisplayed(), "T-shirts is not displayed!");
    }
}
