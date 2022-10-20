package UI_Tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public final SelenideElement authBtn = $x("//div[@class='ll-leokit__site-menu__auth-wrapper']");
    public final SelenideElement authLink = $x("//span[text()='I ALREADY HAVE AN ACCOUNT']");
    public final SelenideElement emailT = $x("//input[@placeholder='E-mail']");
    public final SelenideElement passT = $x("//input[@placeholder='Password']");
    public final SelenideElement enterBtn = $("button[class*='alt__submit']");
    public final SelenideElement afterAuth = $("h1[class$='main__title']");
    public final SelenideElement firstStep = $("div[class$='step__image']");
    public final SelenideElement firstTask = $x("//div[@class='ll-leokit__map-popups-tasks__title']");
    public final SelenideElement taskCloseBtn = $x("//div[@class='ll-leokit__map-popups-tasks__close']");

    public void newAuth(String email, String pass){
        authBtn.click();
        authLink.shouldBe(Condition.visible).click();
        emailT.shouldBe(Condition.visible).sendKeys(email);
        passT.sendKeys(pass);
        enterBtn.click();
        afterAuth.should(Condition.visible, Duration.ofSeconds(20));
        afterAuth.shouldHave(Condition.text("Карта обучения"));
    }

    public void firstTask(){
        firstStep.should(Condition.visible, Duration.ofSeconds(10)).click();
        firstTask.shouldHave(Condition.text("Я должен признаться"));
        taskCloseBtn.click();
    }
}
