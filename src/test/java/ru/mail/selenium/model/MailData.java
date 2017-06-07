package ru.mail.selenium.model;

public class MailData {
    private final String to;
    private final String subject;

    public MailData(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }
}
