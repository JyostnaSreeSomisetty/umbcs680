package umbcs680.gmail;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import umbcs680.gmail.Email;
import umbcs680.gmail.GmailClient;
import umbcs680.gmail.EmailServer;
import umbcs680.gmail.EmailClient;

import java.util.ArrayList;
import java.util.List;

public class EmailServerTest {

    @Test
    public void testMulticastEmail() {
        // Create email server
        EmailServer emailServer = new EmailServer();

        // Create mock clients using LEs
        List<Boolean> receivedList = new ArrayList<>();
        EmailClient mockClient1 = (Email email) -> receivedList.add(true);
        EmailClient mockClient2 = (Email email) -> receivedList.add(true);

        // Register mock clients with the server
        emailServer.registerClient(mockClient1);
        emailServer.registerClient(mockClient2);

        // Multicast an email
        Email email = new Email("sender@example.com", "Test Subject", "Test Body");
        emailServer.multicastEmail(email);

        // Check if both clients received the email
        assertTrue(receivedList.size() == 2);
        assertTrue(receivedList.get(0));
        assertTrue(receivedList.get(1));
    }
}