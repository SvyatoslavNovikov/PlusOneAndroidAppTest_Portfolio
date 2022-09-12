package screens.onboarding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsefulMap extends OnboardingLayout{

    public UsefulMap(AppiumDriver<MobileElement> driver) {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.poleznygorod.cityplusone:id/appCompatTextView")
    public MobileElement title;

    @FindBy(id = "com.poleznygorod.cityplusone:id/appCompatTextView4")
    public MobileElement text;

    @FindBy(id = "com.poleznygorod.cityplusone:id/button_next")
    public MobileElement button;

}
