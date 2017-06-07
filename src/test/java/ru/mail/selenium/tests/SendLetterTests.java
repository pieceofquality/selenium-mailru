package ru.mail.selenium.tests;

import org.testng.annotations.Test;
import ru.mail.selenium.model.MailData;

/**
 * Created by piece on 6/5/2017.
 */
public class SendLetterTests extends TestBase {

    @Test
    public void testEmptyMessageSending(){
        app.getMailHelper().initMailCreation();
        app.getMailHelper().fillMailForm(new MailData("test@mail.ru", "test"));
        app.getMailHelper().submitMail();
    }
}
