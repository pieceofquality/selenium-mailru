package ru.mail.selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private MailHelper mailHelper;
    private String browser;
    private NavigationHelper navigationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws IOException {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://mail.ru/");
        sessionHelper = new SessionHelper(wd);
        mailHelper = new MailHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("testisok", "Banan666");

    }

    public void stop() {
        wd.quit();
    }


    public MailHelper getMailHelper() {
        return mailHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
