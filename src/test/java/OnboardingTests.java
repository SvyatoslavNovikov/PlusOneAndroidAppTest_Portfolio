import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Greetings;

public class OnboardingTests extends BaseClass {

    @Test(description = "APPS-1 При запуске приложения отображается заставка +1Город")
    public void apps1() {
        Greetings greetingsView = new Greetings(driver);
        greetingsView.loader.isDisplayed();
    }

    @Test(dependsOnMethods = "apps1", description = "APPS-2 Экран \"Полезная карта\" отображается при первом запуске приложения после заставки")
    public void apps2() throws InterruptedException {
        final Wait<WebDriver> wait = new WebDriverWait(driver, 120).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOf(useful.title));
        Assert.assertEquals(useful.title.getText(), "Полезная карта");
    }

    @Test(dependsOnMethods = "apps2", description = "APPS-3 На экране \"Полезная карта\" активна первая точка в пагинаторе")
    public void apps3() {
        Assert.assertEquals(useful.paginator.get(0).getAttribute("selected"), "true");
        Assert.assertEquals(useful.paginator.get(1).getAttribute("selected"), "false");
        Assert.assertEquals(useful.paginator.get(2).getAttribute("selected"), "false");
    }

    @Test(dependsOnMethods = "apps3", description = "APPS-7 При свайпе на право происходит переход с экрана \"полезная карта\" на экран \"почему карта полезная\"")
    public void apps7() {
        useful.swipeToNextScreen();
        Assert.assertEquals(whyUseful.title.getText(), "Почему карта \nполезная?");
    }

    @Test(dependsOnMethods = "apps7", description = "APPS-17 При свайпе налево происходит переход с экрана \"почему карта полезная\" на экран \"полезная карта\"")
    public void apps17() {
        whyUseful.swipeToPreviousScreen();
        Assert.assertEquals(useful.title.getText(), "Полезная карта");
    }

    @Test(dependsOnMethods = "apps17", description = "APPS-16 При клике на далее происходит переход с экрана \"полезная карта\" на экран \"почему карта полезная\"")
    public void apps16() {
        useful.button.click();
        Assert.assertEquals(whyUseful.title.getText(), "Почему карта \nполезная?");
    }

    @Test(dependsOnMethods = "apps16", description = "APPS-21 На экране \"Почему карта полезная\" вторая точка в пагинаторе активна")
    public void apps21() {
        Assert.assertEquals(useful.paginator.get(0).getAttribute("selected"), "false");
        Assert.assertEquals(useful.paginator.get(1).getAttribute("selected"), "true");
        Assert.assertEquals(useful.paginator.get(2).getAttribute("selected"), "false");
    }

    @Test(dependsOnMethods = "apps21", description = "APPS-18 При свайпе направо происходит переход с экрана \"почему карта полезная\" на экран \"что такое программа лояльности\"")
    public void apps18() {
        whyUseful.swipeToNextScreen();
        Assert.assertEquals(whatIsLoyalty.title.getText(), "Что такое программа лояльности?");
    }

    @Test(dependsOnMethods = "apps18", description = "APPS-24 На экране \"что такое программа лояльности\" активна третья точка в пагинаторе")
    public void apps24() {
        Assert.assertEquals(useful.paginator.get(0).getAttribute("selected"), "false");
        Assert.assertEquals(useful.paginator.get(1).getAttribute("selected"), "false");
        Assert.assertEquals(useful.paginator.get(2).getAttribute("selected"), "true");
    }

    @Test(dependsOnMethods = "apps18", description = "APPS-28 На экране лояльности отображается актуальный текст")
    public void apps28() {
        Assert.assertEquals(whatIsLoyalty.text.get(0).getText(), "Выполняй простые полезные действия и получай за это баллы лояльности");
        Assert.assertEquals(whatIsLoyalty.text.get(1).getText(), "Обменивай баллы на партнёрские призы и баллы лояльности других брендов");
        Assert.assertEquals(whatIsLoyalty.text.get(2).getText(), "Сделай добрые дела своей привычкой и получай за это бонусы, скидки и подарки");
    }

    @Test(dependsOnMethods = "apps28", description = "APPS-20 При свайпе налево происходит переход с экрана \"что такое программа лояльности\" на экран \"почему карта полезная\"")
    public void apps20() {
        whatIsLoyalty.swipeToPreviousScreen();
        Assert.assertEquals(whyUseful.title.getText(), "Почему карта \nполезная?");
    }

    @Test(dependsOnMethods = "apps20", description = "APPS-19 При клике на далее происходит переход с экрана \"почему карта полезная\" на экран \"что такое программа лояльности\"")
    public void apps19() throws InterruptedException {
        whyUseful.button.click();
        Assert.assertEquals(whatIsLoyalty.title.getText(), "Что такое программа лояльности?");
    }

    @Test(dependsOnMethods = "apps19", description = "APPS-14 При клике на системную кнопку back на одном из экранов приветствия приложение сворачивается")
    public void apps14() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        ApplicationState state = driver.queryAppState("com.poleznygorod.cityplusone");
        Assert.assertEquals(state.toString(), "RUNNING_IN_BACKGROUND");
    }
}