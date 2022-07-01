import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Methods extends BaseMethods {

    protected AppiumDriver<?> driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = BaseMethods.returnDriver(System.getenv("TESTING_PLATFORM")); //?
        //driver = BaseMethods.returnDriver(BaseMethods.readProperty("run.platform"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // random string generation
    public static String generateRandomHexString (int length){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }

    protected void skipStartCarousel() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        RegistrationPage startPage = new RegistrationPage(this.driver);
        RegistrationPage registrationPage = new RegistrationPage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);
        SoftAssert softAssert = new SoftAssert();

        /*wait.until(ExpectedConditions.elementToBeClickable((startPage.firstSlideHeader)));
        startPage.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((startPage.secondSlideFooterText)));
        startPage.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((startPage.thirdSlideFooterText)));
        startPage.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((startPage.fourthSlideFooterText)));
        startPage.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((startPage.startButton)));
        startPage.startButton.click();

        /*softAssert.assertTrue(cityPage.cityHeaderText.isDisplayed(), "cityHeader is not displayed");
        wait.until(ExpectedConditions.elementToBeClickable((cityPage.firstCity)));
        Thread.sleep(1000);
        cityPage.firstCity.click();
        wait.until(ExpectedConditions.elementToBeClickable((mainPage.mainButton)));
        softAssert.assertTrue(mainPage.mainButton.isDisplayed(), "mainButton is not displayed");*/
    }

}

