package ru.mail.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.id("mailbox__login"), username);
        type(By.id("mailbox__password"), password);
        click(By.id("mailbox__auth__button"));
    }
}
