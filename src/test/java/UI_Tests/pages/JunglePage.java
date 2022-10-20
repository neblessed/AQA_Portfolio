package UI_Tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class JunglePage {
    public final SelenideElement jungleBtn = $x("//*[text()='Jungle']");
    public final SelenideElement booksAndArticlesBtn = $x("//*[text()='Books and articles']");
    public final SelenideElement getFirstPost = $x("//h2[@class='ll-leokit__card__title']");
    public final SelenideElement firstPostVerify = $x("//h1[@class='ll-jungle-content__header']");

    public void newestPost(){
        jungleBtn.click();
        booksAndArticlesBtn.click();
        String firstPost = getFirstPost
                .should(Condition.visible, Duration.ofSeconds(10))
                .getText();
        getFirstPost.click();
        firstPostVerify.shouldHave(Condition.text(firstPost));
    }
}
