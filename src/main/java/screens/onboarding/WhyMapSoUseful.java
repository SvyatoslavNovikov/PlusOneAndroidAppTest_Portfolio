package screens.onboarding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WhyMapSoUseful extends OnboardingLayout{

    private AppiumDriver<MobileElement> driver;

    public WhyMapSoUseful(AppiumDriver<MobileElement> driver) {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.poleznygorod.cityplusone:id/title_onboarding")
    public MobileElement title;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout")
    public List<MobileElement> text;

    @FindBy(id = "com.poleznygorod.cityplusone:id/button_next")
    public MobileElement button;

}
