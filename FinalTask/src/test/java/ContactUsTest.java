import helper.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.MyStorePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import webdriver.WebDriverConfiguration;

@Listeners(Listener.class)
public class ContactUsTest {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private ContactUsPage contactUsPage;

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
    @TestCaseId("E-1")
    @Features("Contact us")
    @Stories("Verify that contact us form sends successfully")
    public void contactUsPositiveTest() {
        contactUsPage = myStorePage.contactUsClick();
        contactUsPage.contactUs("igor_vengeance@mail.ru","0123456789","C:\\Users\\root\\Desktop\\AttachFile.txt","This is automated test!");
        Assert.assertEquals(contactUsPage.getSuccessMessageText(), "Your message has been successfully sent to our team.");
    }

    @Test
    @TestCaseId("E-2")
    @Features("Contact us")
    @Stories("Verify that error message appears if Message area is empty")
    public void contactUsNegativeTest() {
        contactUsPage = myStorePage.contactUsClick();
        contactUsPage.contactUs("igor_vengeance@mail.ru","0123456789","C:\\Users\\root\\Desktop\\AttachFile.txt","");
        Assert.assertEquals(contactUsPage.getErrorMessageText(), "The message cannot be blank.");
    }
}
