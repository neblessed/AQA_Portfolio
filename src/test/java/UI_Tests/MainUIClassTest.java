package UI_Tests;

import UI_Tests.config.BaseSettings;
import UI_Tests.pages.JunglePage;
import UI_Tests.pages.LoginPage;
import UI_Tests.pages.PremiumPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import UI_Tests.pages.MainPage;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class MainUIClassTest extends BaseSettings {
    MainPage mainPage = new MainPage(BASE_URL);
    LoginPage loginPage = new LoginPage();
    PremiumPage premiumPage = new PremiumPage();
    JunglePage junglePage = new JunglePage();

    @Test
    @DisplayName("1. Отображение заголовка на странице")
    public void checkMainTitle(){
        mainPage.checkMainTitle();
    }

    @Test
    @DisplayName("2. Проверка актуальных цен")
    public void checkActualPrices(){
        premiumPage.checkPrices("749", "4190", "7990");
    }

    @Test
    @DisplayName("3. Проверка поста на странице Jungle")
    public void checkNewestPost(){junglePage.newestPost(); }

    @Test
    @DisplayName("4. Успешная авторизация")
    public void succsessAuth(){
        loginPage.newAuth("fwmbagg@mail.ru", "Qwerty123");
    }

    @Test
    @DisplayName("5. Окно с первым заданием")
    public void doFirstTask(){
        loginPage.firstTask();
    }

    @Test
    @DisplayName("6. Кнопка 'Купить' инициирует появление формы оплаты")
    public void purchaseCourse(){
        premiumPage.purchaseAnyCourse();
    }
}
