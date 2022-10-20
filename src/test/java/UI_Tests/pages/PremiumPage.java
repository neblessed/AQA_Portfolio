package UI_Tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PremiumPage {

    public final SelenideElement premiumBtn = $x("//div[@class='ll-premium-indicator__text']");
    public final SelenideElement premiumBtnAfterAuth = $x("//div[@class='ll-leokit__site-menu__premium-status']//div[@class='ll-premium-indicator__text']");
    public final SelenideElement oneMonthCourse = $x("//div[text()='1 month']//following::div[1]/div");
    public final SelenideElement oneYearCourse = $("div[class$='m-selected'] div[class$='price-actual']");
    public final SelenideElement twoYearsCourse = $x("//div[text()='24 months']//following::div[1]/div");
    public final SelenideElement premiumPageTitle = $("div[class$='m-tariffs']");
    public final SelenideElement purchaseBtn = $x("//div[@class='ll-leokit__premium-card__btn-wrapper']/following::span[1]");
    public final SelenideElement infoPurchase = $x("//div[@class='ll-leokit__payment-new__info-title']");

    public void checkPrices(String oneMonth, String oneYear, String twoYears){
        premiumBtn.click();
        oneMonthCourse.should(Condition.visible, Duration.ofSeconds(10))
                .getText()
                .contains(oneMonth);
        oneYearCourse.getText().contains(oneYear);
        twoYearsCourse.getText().contains(twoYears);
        premiumPageTitle.getText().contains("Premium plans");
    }

    public void purchaseAnyCourse(){
        premiumBtnAfterAuth.should(Condition.visible, Duration.ofSeconds(5)).click();
        purchaseBtn.click();
        infoPurchase.shouldBe(Condition.visible)
                .getText()
                .contains("Что вы получите");
    }
}
