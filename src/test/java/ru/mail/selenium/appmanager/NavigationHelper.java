package ru.mail.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToDrafts() {
        click(By.xpath("//span[.='Черновики']"));
    }

    public void goToSent() {
        click(By.xpath("//span[.='Отправленные']"));
    }
}
