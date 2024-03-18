package umbcs680.gmail;

import java.util.ArrayList;
import java.util.List;

import umbcs680.gmail.EmailClient;
import umbcs680.gmail.NotificationClient;
import umbcs680.gmail.Email;
import umbcs680.gmail.GmailClient;


public class EmailServer {
    private List<umbcs680.gmail.EmailClient> clients = new ArrayList<>();

    public void registerClient(EmailClient client) {
        clients.add(client);
    }

    public void unregisterClient(EmailClient client) {
        clients.remove(client);
    }

    public void multicastEmail(Email email) {
        for (EmailClient client : clients) {
            client.receiveEmail(email);
        }
    }

    // SMS Subscriber class
    static class SMSSubscriber implements EmailClient {
        private String phoneNumber;

        public SMSSubscriber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public void receiveEmail(Email email) {
            System.out.println("SMS notification sent to " + phoneNumber + ": You have received an email from " + email.getSender());
        }
    }

    // Main class included as a static nested class
    public static class Main {
        public static void main(String[] args) {
            EmailServer emailServer = new EmailServer();

            // Create Gmail clients
            GmailClient client1 = new GmailClient("user1@gmail.com");
            GmailClient client2 = new GmailClient("user2@gmail.com");

            // Create SMS subscriber
            SMSSubscriber smsSubscriber = new SMSSubscriber("+123456789");

            // Create notification client
            NotificationClient notificationClient = new NotificationClient("user123");

            // Register clients with the server
            emailServer.registerClient((EmailClient) client1);
            emailServer.registerClient((EmailClient) client2);
            emailServer.registerClient(smsSubscriber);
            emailServer.registerClient(notificationClient);

            // Multicast an email
            Email email = new Email("sender@example.com", "Meeting Agenda", "Please find attached the agenda for the meeting.");
            emailServer.multicastEmail(email);
        }
    }
}
