import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseMethods {
    public static String readProperty(String property) {
        Properties prop;
        String value = null;
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("config.properties")));

            value = prop.getProperty(property);

            if (value == null || value.isEmpty()) {
                throw new Exception("Value not set or empty");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static AppiumDriver<?> returnDriver(String platform) throws Exception {

       String IOS_APP_PATH = System.getenv("IOS_APP_PATH");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AppiumDriver<?> driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (platform.toLowerCase()) {

            case "android":
                capabilities.setCapability("deviceName", "sdk_gphone64_arm64");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("app", "/Users/belikova/Downloads/newsfeed.apk");

                driver = new AndroidDriver<MobileElement>(url, capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            case "ios":
                capabilities.setCapability("deviceName", "iPhone 13");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformVersion", "15.5");
                capabilities.setCapability("autoAcceptAlerts", "true");
                capabilities.setCapability("app", "/Users/belikova/Downloads/newsfeed.app");

                driver = new IOSDriver<MobileElement>(url, capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            default:
                throw new Exception("Platform not supported");
        }

        return driver;
    }
}
