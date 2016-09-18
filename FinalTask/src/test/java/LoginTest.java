import helper.Listener;
import helper.RandomUtils;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyStorePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import webdriver.WebDriverConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

@Listeners(Listener.class)
public class LoginTest {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

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
    @TestCaseId("E-3")
    @Features("Login")
    @Stories("Verify the ability to register")
    public void loginTest() {
        loginPage = myStorePage.loginPageClick();
        String string = RandomStringUtils.random(5, true, true);
        String numbers = RandomStringUtils.random(5, false, true);
        String letters = RandomStringUtils.random(5, true, false);
        myAccountPage = loginPage.createAnAccount(RandomUtils.getRandomEmail(), letters, letters, string, string, letters, numbers, numbers);
        Assert.assertTrue("Account page is not displayed!", myAccountPage.isSignOutButtonDisplayed());
    }
}
