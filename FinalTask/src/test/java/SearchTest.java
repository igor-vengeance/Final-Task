import helper.Listener;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MyStorePage;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import webdriver.WebDriverConfiguration;

@Listeners(Listener.class)
public class SearchTest {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfiguration.setLocalDriver();
        myStorePage = new MyStorePage(driver);
        myStorePage.load();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    @TestCaseId("E-4")
    @Features("Search")
    @Stories("Verify the ability to search items")
    public void searchTest() {
        searchPage =  myStorePage.search("blouse");
        Assert.assertTrue("Search item is not displayed!", searchPage.isSearchItemDisplayed());
    }
}
