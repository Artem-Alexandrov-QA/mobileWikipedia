package com.alexandrov.tests.local;

import com.alexandrov.drivers.BrowserstackMobileDriver;
import com.alexandrov.drivers.LocalDriver;
import com.alexandrov.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.alexandrov.helpers.Attach.getSessionId;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {
    static String deviceHost = System.getProperty("deviceHost", "local");
    @BeforeAll
    public static void setup() {

        if (Objects.equals(deviceHost, "local")) {
            Configuration.browser = LocalDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);
        if (Objects.equals(deviceHost, "browserstack")) {
            Attach.video(sessionId);
        }
    }
}