package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class KinopoiskTest extends TestBase {

    @Test
    void searchTest() {

        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });

        step("Вводим в строку поиска: сериалы", () -> {
            $(byName("kp_query")).click();
            $(byName("kp_query")).val("сериалы").pressEnter();
        });

        step("проверяем, что на открытой странице есть текст: поиск: сериалы", () -> {
            $(".search_results_topText").shouldHave(text("поиск: сериалы"));
        });
    }
}
