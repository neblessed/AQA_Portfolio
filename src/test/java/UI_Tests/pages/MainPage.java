package UI_Tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage (String url){
        Selenide.open(url);
    }

    public final SelenideElement mailLabel = $("div[class*='section-1__title']");

    public void checkMainTitle(){
        mailLabel.getText().contains("The World is Yours with Lingualeo!");
    }

}
