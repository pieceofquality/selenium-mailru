package ru.mail.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.mail.selenium.model.MailData;

/**
 * Created by piece on 6/5/2017.
 */
public class MailHelper extends HelperBase {

    public MailHelper(WebDriver wd){

        super(wd);
    }

    public void initMailCreation(){
        click(By.linkText("Написать письмо"));
    }

    public void fillMailForm(MailData mailData){
        type(By.cssSelector("textarea[data-original-name=To]"), mailData.getTo());
        wd.findElement(By.cssSelector("textarea[data-original-name=To]")).sendKeys(Keys.RETURN);
        type(By.cssSelector("input[name=Subject]"), mailData.getSubject());
    }

    public void submitMail() {
        click(By.cssSelector("div[data-name=send]"));
    }
}
