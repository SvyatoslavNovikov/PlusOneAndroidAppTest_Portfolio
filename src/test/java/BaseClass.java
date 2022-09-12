import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import jcactus.Device;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.testproject.sdk.drivers.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import screens.onboarding.UsefulMap;
import screens.onboarding.WhatIsLoyalty;
import screens.onboarding.WhyMapSoUseful;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    AndroidDriver<MobileElement> driver;

    UsefulMap useful;
    WhyMapSoUseful whyUseful;
    WhatIsLoyalty whatIsLoyalty;

    @BeforeClass
    public void setup() throws Exception {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

//            Device device = new Device("pixel");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.UDID, "UDID_DEVICE_HERE");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.poleznygorod.cityplusone");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.poleznygorod.cityplusone.StartActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<>(capabilities, "Svyatoslav Novikov");   // Если нужно, токен можно указать тут, первым параметром
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("jcactus.Message is: " + exp.getMessage());
            exp.printStackTrace();
        }

        useful = new UsefulMap(driver);
        whyUseful = new WhyMapSoUseful(driver);
        whatIsLoyalty = new WhatIsLoyalty(driver);

        GeneratedUtils.sleep(500);
        driver.resetApp();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
