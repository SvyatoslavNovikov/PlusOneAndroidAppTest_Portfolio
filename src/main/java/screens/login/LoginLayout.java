package screens.login;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginLayout {

    @FindBy(id = "com.poleznygorod.cityplusone:id/button_skip")
    public MobileElement skip;

    @FindBy(id = "com.poleznygorod.cityplusone:id/appCompatTextView2")
    public MobileElement title;

    @FindBy(id = "com.poleznygorod.cityplusone:id/vk_signup_icon")
    public MobileElement vk;

    @FindBy(id = "com.poleznygorod.cityplusone:id/facebook_signup_icon")
    public MobileElement facebook;

    @FindBy(id = "com.poleznygorod.cityplusone:id/google_signup_icon")
    public MobileElement google;

}
