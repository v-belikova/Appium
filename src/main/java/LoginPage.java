import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage (AppiumDriver<?> driver)
    {PageFactory.initElements(new AppiumFieldDecorator(driver), this);}

    //@AndroidFindBy(xpath = "//*[contains(@resource-id, 'START_CAROUSEL:NEXT_BUTTON')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Email'])[2]/XCUIElementTypeTextField")
    public MobileElement emailInput;

    //@AndroidFindBy(xpath = "//*[contains(@resource-id, 'START_CAROUSEL:PREV_BUTTON')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Password'])[2]/XCUIElementTypeSecureTextField")
    public MobileElement passwordInput;

    //@AndroidFindBy(xpath = "//*[contains(@resource-id, 'START_CAROUSEL:PREV_BUTTON')]")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement buttonLogin;

    //@AndroidFindBy(xpath = "//*[contains(@resource-id, 'START_CAROUSEL:PREV_BUTTON')]")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement buttonRegister;



}
