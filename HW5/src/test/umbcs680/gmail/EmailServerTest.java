package umbcs680.gmail;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

import umbcs680.gmail.Email;
import umbcs680.gmail.GmailClient;
import umbcs680.gmail.EmailServer;
import umbcs680.gmail.EmailClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailServerTest {

    @Test
    public void testMulticastEmail() {
        // Create email server
        EmailServer emailServer = new EmailServer();

        // Create mock clients
        MockClient client1 = new MockClient();
        MockClient client2 = new MockClient();

        // Register mock clients with the server
        emailServer.registerClient(client1);
        emailServer.registerClient(client2);

        // Multicast an email
        Email email = new Email("sender@example.com", "Test Subject", "Test Body");
        emailServer.multicastEmail(email);

        // Check if both clients received the email
        assertTrue(client1.received);
        assertTrue(client2.received);
    }

    // Mock client class for testing
    private static class MockClient implements EmailClient {
        private boolean received = false;

        @Override
        public void receiveEmail(Email email) {
            received = true;
        }
    }
}
