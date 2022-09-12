import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jcactus.Device;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            Device device = new Device("pixel");

            caps.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
            caps.setCapability(MobileCapabilityType.UDID, device.getUdid());
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getPlatformName());
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

            caps.setCapability("appPackage", "com.poleznygorod.cityplusone");
            caps.setCapability("appActivity", "com.poleznygorod.cityplusone.StartActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<MobileElement>(url, caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("jcactus.Message is: " + exp.getMessage());
            exp.printStackTrace();
        }

        useful = new UsefulMap(driver);
        whyUseful = new WhyMapSoUseful(driver);
        whatIsLoyalty = new WhatIsLoyalty(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
