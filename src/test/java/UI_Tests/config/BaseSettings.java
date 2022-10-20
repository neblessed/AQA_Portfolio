package UI_Tests.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseSettings {
    public final static String BASE_URL = "https://lingualeo.com/en";

    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



}
