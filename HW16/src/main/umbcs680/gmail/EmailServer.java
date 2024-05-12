package umbcs680.gmail;

import java.util.ArrayList;
import java.util.List;

import umbcs680.gmail.EmailClient;
import umbcs680.gmail.NotificationClient;
import umbcs680.gmail.Email;
import umbcs680.gmail.GmailClient;


public class EmailServer {
    private List<EmailClient> clients = new ArrayList<>();

    public void registerClient(EmailClient client) {
        clients.add(client);
    }

    public void unregisterClient(EmailClient client) {
        clients.remove(client);
    }

    public void multicastEmail(Email email) {
        clients.forEach(client -> client.receiveEmail(email));
    }

    public static class Main {
        public static void main(String[] args) {
            EmailServer emailServer = new EmailServer();

            // Create Gmail clients
            GmailClient client1 = new GmailClient("user1@gmail.com");
            GmailClient client2 = new GmailClient("user2@gmail.com");

            // Create SMS subscriber
            EmailClient smsSubscriber = (Email email) -> System.out.println("SMS notification sent to +123456789: You have received an email from " + email.getSender());

            // Create notification client
            EmailClient notificationClient = (Email email) -> System.out.println("Notification sent to user123: You have received an email from " + email.getSender());

            // Register clients with the server
            emailServer.registerClient(client1);
            emailServer.registerClient(client2);
            emailServer.registerClient(smsSubscriber);
            emailServer.registerClient(notificationClient);

            // Multicast an email
            Email email = new Email("sender@example.com", "Meeting Agenda", "Please find attached the agenda for the meeting.");
            emailServer.multicastEmail(email);
        }
    }
}