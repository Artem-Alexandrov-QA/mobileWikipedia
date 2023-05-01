package com.alexandrov.drivers;

import com.alexandrov.config.BrowserstackConfig;
import com.alexandrov.config.Credentials;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.merge(capabilities);
        caps.setCapability("browserstack.user", config.username());
        caps.setCapability("browserstack.key", config.password());
        caps.setCapability("app", Credentials.config.app());
        caps.setCapability("device", "Samsung Galaxy S22 Plus");
        caps.setCapability("os_version", "12.0");
        caps.setCapability("project", "Java Project");
        caps.setCapability("build", "browserstack");
        caps.setCapability("name", "first_test");
        return new RemoteWebDriver(getBrowserstackUrl(), caps);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}