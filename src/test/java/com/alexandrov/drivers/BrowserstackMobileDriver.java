package com.alexandrov.drivers;

import com.alexandrov.config.Credentials;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Credentials.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {
        caps.setCapability("browserstack.user", Credentials.config.username());
        caps.setCapability("browserstack.key", Credentials.config.password());
        caps.setCapability("app", Credentials.config.app());
        caps.setCapability("device", "Samsung Galaxy S22 Plus");
        caps.setCapability("os_version", "12.0");
        caps.setCapability("project", "Java Project");
        caps.setCapability("build", "browserstack");
        caps.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}