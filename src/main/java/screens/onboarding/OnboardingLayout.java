package screens.onboarding;

import driver.Swipe;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnboardingLayout {

    AppiumDriver<MobileElement> driver;

    @FindBy(id = "com.poleznygorod.cityplusone:id/button_skip")
    public MobileElement skip;

    @FindBy(xpath = "//android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab")
    public List<MobileElement> paginator;

    public void swipeToNextScreen() {
        new Swipe(driver).swipeScreen(Swipe.Direction.LEFT);
    }

    public void swipeToPreviousScreen() {
        new Swipe(driver).swipeScreen(Swipe.Direction.RIGHT);
    }

}
