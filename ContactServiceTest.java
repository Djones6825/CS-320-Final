import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {


    private ContactService contactService;

    @BeforeEach
    void setUp() {
        // Initialize the contact service before each test
        contactService = new ContactService();
    }

    // Test case for creating a valid Contact object
    @Test
    void testCreateValidContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        assertNotNull(contact);
        assertEquals("C001", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getphoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test case for invalid contact ID (too long)
    @Test
    void testCreateContactWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C00123456789", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case for invalid first name (too long)
    @Test
    void testCreateContactWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C002", "Johnathan", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case for invalid phone number (not 10 digits)
    @Test
    void testCreateContactWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C003", "Jane", "Smith", "12345", "456 Oak Ave");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C004", "Jane", "Smith", "12345678901", "456 Oak Ave");
        });
    }

    // Test case for invalid address (too long)
    @Test
    void testCreateContactWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C005", "Alice", "Johnson", "1234567890", "This is a very long address that exceeds the limit.");
        });
    }

    // Test case for adding a valid contact to the service
    @Test
    void testAddContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Verify the contact is added
        assertEquals(contact, contactService.getContact("C001"));
    }

    // Test case for adding a contact with duplicate ID (should throw exception)
    @Test
    void testAddDuplicateContact() {
        Contact contact1 = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C001", "Jane", "Doe", "0987654321", "456 Oak Ave");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    // Test case for deleting a contact
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("C001");

        // Verify the contact is deleted
        assertNull(contactService.getContact("C001"));
    }

    // Test case for deleting a non-existing contact (should throw exception)
    @Test
    void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("C001");
        });
    }

    // Test case for updating contact information
    @Test
    void testUpdateContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update contact information
        contactService.updateContact("C001", "Johnny", "Doe", "1112223333", "789 Pine St");

        // Verify the updates
        Contact updatedContact = contactService.getContact("C001");
        assertEquals("Johnny", updatedContact.getFirstName());
        assertEquals("1112223333", updatedContact.getphoneNumber());
        assertEquals("789 Pine St", updatedContact.getAddress());
    }

    // Test case for updating non-existing contact (should throw exception)
    @Test
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("C001", "Johnny", "Doe", "1112223333", "789 Pine St");
        });
    }

    // Test case for listing all contacts
    @Test
    void testListAllContacts() {
        Contact contact1 = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C002", "Jane", "Smith", "0987654321", "456 Oak Ave");

        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Capture the output
        // In a real scenario, you might redirect std-out to verify the output
        contactService.listAllContacts();  // This will print all contacts in the system
        // You would verify printed output manually, or use a mock system output.
    }
}