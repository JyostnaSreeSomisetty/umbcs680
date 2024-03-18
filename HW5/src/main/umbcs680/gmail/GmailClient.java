package umbcs680.gmail;

import umbcs680.gmail.Email;
import umbcs680.gmail.EmailClient;

public class GmailClient implements EmailClient {
    private String email;

    public GmailClient(String email) {
        this.email = email;
    }

    @Override
    public void receiveEmail(Email email) {
        System.out.println("Received an email at " + this.email + " from " + email.getSender() + " with subject: " + email.getSubject());
    }
}
