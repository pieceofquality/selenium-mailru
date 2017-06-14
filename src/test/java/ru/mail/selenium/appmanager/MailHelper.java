package ru.mail.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        wd.switchTo().frame(wd.findElement(By.cssSelector("iframe[id$='composeEditor_ifr']")));
        type(By.cssSelector("body"), mailData.getBody());
        wd.switchTo().defaultContent();
    }

    public void submitMail() {
        click(By.cssSelector("div[data-name=send]"));
    }

    public void confirmEmptyMail() {
        click(By.cssSelector(".is-compose-empty_in .btn.confirm-ok"));
    }

    public void saveDraft() throws InterruptedException {
        click(By.cssSelector("div[data-name='saveDraft']"));
        Thread.sleep(5000);
    }

    public void logOut() {
        click(By.cssSelector("#PH_logoutLink"));
    }

//    public String Subj = wd.findElement(By.cssSelector(".b-letter__head__subj__text")).getText();

    public void checkSentMailFields(MailData mailData)
    {
        WebElement element;
        element = wd.findElement(By.cssSelector("#b-letters div[data-cache-key='500000_undefined_false'] .b-datalist__body [data-bem='b-datalist__item']"));
        String t = element.getText();
        Assert.assertTrue(t.contains(mailData.getBody()));
        Assert.assertTrue(t.contains(mailData.getSubject()));
        Assert.assertTrue(t.contains(mailData.getTo()));
    }


    public void checkDraftMailFields(MailData mailData)
    {

        WebElement element;
        element = wd.findElement(By.cssSelector("#b-letters div[data-cache-key='500001_undefined_false'] .b-datalist__body [data-bem='b-datalist__item']"));
        String t = element.getText();
        Assert.assertTrue(t.contains(mailData.getBody()));
        Assert.assertTrue(t.contains(mailData.getSubject()));
        Assert.assertTrue(t.contains(mailData.getTo()));

    }
}
