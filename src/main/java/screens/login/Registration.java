package screens.login;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends LoginLayout {

    @FindBy(xpath = "//android.widget.LinearLayout[1]//android.widget.EditText")
    public MobileElement email;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.EditText")
    public MobileElement password;

    @FindBy(xpath = "//android.widget.LinearLayout[3]//android.widget.EditText")
    public MobileElement repeatPassword;

    @FindBy(id = "com.poleznygorod.cityplusone:id/checkBoxTerms")
    public MobileElement checkbox;

    @FindBy(id = "com.poleznygorod.cityplusone:id/termsAgreement")
    public MobileElement terms;

    @FindBy(id = "com.poleznygorod.cityplusone:id/button_get_code")
    public MobileElement register;

    @FindBy(id = "com.poleznygorod.cityplusone:id/switch_sign_type")
    public MobileElement authorization;

}
