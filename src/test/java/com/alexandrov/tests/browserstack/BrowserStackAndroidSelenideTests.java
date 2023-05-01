package com.alexandrov.tests.browserstack;

import com.alexandrov.tests.local.TestBase;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;


@Tag("android")
@DisplayName("Проверка мобильного приложения Wikipedia")
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @Feature("WikiSearch")
    @Owner("A.Alexandrov")
    @DisplayName("Проверка отображения результатов поиска")
    void searchTest() {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0));
    }

    @Test
    @Feature("WikiSearch")
    @Owner("A.Alexandrov")
    @DisplayName("Проверка языка поиска")
    void openArticleFromSearchTest() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        $$(byClassName("android.widget.TextView")).first().shouldHave(text("EN"));
    }
}