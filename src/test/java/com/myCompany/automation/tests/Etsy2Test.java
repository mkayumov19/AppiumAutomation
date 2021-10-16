package com.myCompany.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class Etsy2Test {
    AppiumDriver<MobileElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        capabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
    }

    @Test
    public void test1() throws InterruptedException {
        MobileElement searchInput;
        driver.findElementById("com.etsy.android:id/btn_link").click();
        Thread.sleep(1000);
        driver.findElementById("com.etsy.android:id/edit_username").sendKeys("areatha@uspeakw.com");
        Thread.sleep(1000);
        driver.findElementById("com.etsy.android:id/edit_password").sendKeys("Cybertek2020");
        Thread.sleep(1000);
        driver.findElementById("com.etsy.android:id/button_signin").click();
        Thread.sleep(2000);
        searchInput = driver.findElementById("com.etsy.android:id/search_src_text");
        searchInput.click();
        searchInput = driver.findElementById("com.etsy.android:id/search_src_text");
        searchInput.click();
        String text = "unique gift";
        Actions actions = new Actions(driver);
        actions.sendKeys(searchInput, text).perform();

        List<MobileElement> populatedResults = driver.findElementsById("com.etsy.android:id/query_text");
        populatedResults.get(0).click(); // click on 1st populated result
        Thread.sleep(2000);
        List<MobileElement> searchResults = driver.findElementsById("com.etsy.android:id/listing_title");

        searchResults.forEach( e -> System.out.println(e.getText()+"\n"));
        searchResults.forEach( e -> Assert.assertTrue(e.getText().toLowerCase(Locale.ROOT).contains("gift")));
        Thread.sleep(2000);

    }

    @After
    public void tearDown(){
        driver.closeApp();
    }
}
