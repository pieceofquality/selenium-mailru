package ru.mail.selenium.tests;

import org.testng.annotations.Test;
import ru.mail.selenium.model.MailData;

public class SendLetterTests extends TestBase {

    @Test
    public void testEmptyMessageSending(){
        app.getMailHelper().initMailCreation();
        app.getMailHelper().fillMailForm(new MailData("test@mail.ru", "test"));
        app.getMailHelper().submitMail();
        app.getMailHelper().confirmEmptyMail();
    }
}
