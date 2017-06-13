


package ru.mail.selenium.tests;

import org.testng.annotations.Test;
import ru.mail.selenium.model.MailData;

public class SendLetterTests extends TestBase {

    @Test
    public void testEmptyMessageSending(){
        app.getMailHelper().initMailCreation();
        app.getMailHelper().fillMailForm(new MailData("test@mail.ru", "test", ""));
        app.getMailHelper().submitMail();
        app.getMailHelper().confirmEmptyMail();
    }

//        1. Авторизоваться в системе пользователем
//        2. Нажать кнопку «Создать письмо» / «Написать письмо».
//        3. Заполнить поля «Кому», «Тема» и «Тело» и сохранить письмо как черновик.
//        4. Открыть папку с черновиками и проверить поля «Кому», «Тема» и «Тело» созданного письма
//        5. Выход из системы с помощью нажатия «Выход»/«Выйти»

    @Test
    public void testDraftMail() throws InterruptedException {
        app.getMailHelper().initMailCreation();
        app.getMailHelper().fillMailForm(new MailData("test@mail.ru", "test", "test"));
        app.getMailHelper().saveDraft();
        app.getNavigationHelper().goToDrafts();
        app.getMailHelper().checkDraftMailFields("test", "test", "test");
        app.getMailHelper().logOut();
    }


//1. Авторизоваться в системе пользователем
//2. Нажать кнопку «Создать письмо» / «Написать письмо».
//3. Заполнить поля «Кому», «Тема» и «Тело» корректными/допустимыми данными и отправить письмо.
//4. Открыть папку с отправленными письмами и проверить поля «Кому», «Тема» и «Тело» отправленного письма
//5. Выход из системы с помощью нажатия «Выход»/«Выйти»

    @Test
    public void testSentMail(){
        app.getMailHelper().initMailCreation();
        app.getMailHelper().fillMailForm(new MailData("testisok@mail.ru", "testsubject", "testbody"));
        app.getMailHelper().submitMail();
        app.getNavigationHelper().goToSent();
        app.getMailHelper().checkSentMailFields("testbody", "testsubject", "testisok");
        app.getMailHelper().logOut();
    }

}
