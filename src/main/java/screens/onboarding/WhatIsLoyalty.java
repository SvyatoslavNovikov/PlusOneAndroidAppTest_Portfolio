package screens.onboarding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WhatIsLoyalty extends OnboardingLayout{

    private AppiumDriver<MobileElement> driver;

    public WhatIsLoyalty(AppiumDriver driver) {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.poleznygorod.cityplusone:id/appCompatTextView")
    public MobileElement title;

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.LinearLayout//android.widget.TextView")
    public List<MobileElement> text;

}
