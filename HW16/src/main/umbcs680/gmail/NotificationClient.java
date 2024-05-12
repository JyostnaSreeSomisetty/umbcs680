package umbcs680.gmail;

import umbcs680.gmail.Email;
import umbcs680.gmail.EmailClient;

public class NotificationClient implements EmailClient {
    private String userId;

    public NotificationClient(String userId) {
        this.userId = userId;
    }

    @Override
    public void receiveEmail(Email email) {
        System.out.println("Notification sent to user " + userId + ": You have received an email from " + email.getSender());
    }
}
