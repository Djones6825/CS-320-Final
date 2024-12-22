import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	 // Test case for creating a valid Contact object
    @Test
    void testCreateValidContact() {
        // Create a valid contact
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Assert the contact fields are correctly initialized
        assertNotNull(contact);
        assertEquals("C001", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getphoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test case for invalid length of contact ID (too long)
    @Test
    void testCreateContactWithInvalidId() {
        // Contact ID longer than 10 characters should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C00123456789", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case for invalid length first name (too long)
    @Test
    void testCreateContactWithInvalidFirstName() {
        // First name longer than 10 characters should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C002", "Johnathan", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case for invalid length last name (too long)
    @Test
    void testCreateContactWithInvalidLastName() {
        // Last name longer than 10 characters should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C003", "John", "DoeLongerThanTen", "1234567890", "123 Main St");
        });
    }

    // Test case for invalid phone number (not 10 digits)
    @Test
    void testCreateContactWithInvalidPhoneNumber() {
        // Phone number must be exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C004", "Jane", "Smith", "12345", "456 Oak Ave"); // Too short
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C005", "Jane", "Smith", "12345678901", "456 Oak Ave"); // Too long
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C006", "Jane", "Smith", "12345abcde", "456 Oak Ave"); // Invalid characters
        });
    }

    // Test case for invalid address (too long)
    @Test
    void testCreateContactWithInvalidAddress() {
        // Address longer than 30 characters should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C007", "Alice", "Johnson", "1234567890", "This is a very long address that exceeds the limit.");
        });
    }

    // Test case for updating a valid field (firstName)
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Update the first name
        contact.setFirstName("Johnny");

        // Assert that the first name was updated
        assertEquals("Johnny", contact.getFirstName());
    }

    // Test case for updating a valid field (lastName)
    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Update the last name
        contact.setLastName("Dough");

        // Assert that the last name was updated
        assertEquals("Dough", contact.getLastName());
    }

    // Test case for updating a valid field (phone)
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Update the phone number
        contact.setphoneNumber("9876543210");

        // Assert that the phone number was updated
        assertEquals("9876543210", contact.getphoneNumber());
    }

    // Test case for updating a valid field (address)
    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Update the address
        contact.setAddress("456 Oak Ave");

        // Assert that the address was updated
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Test case for invalid first name (too long)
    @Test
    void testUpdateFirstNameWithInvalidValue() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Try to set a first name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("Johnathan");
        });
    }

    // Test case for invalid phone number (not exactly 10 digits)
    @Test
    void testUpdatePhoneWithInvalidValue() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Try to set an invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setphoneNumber("12345");
        });
    }

    // Test case for invalid address (too long)
    @Test
    void testUpdateAddressWithInvalidValue() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        // Try to set an address that is too long
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This is a very long address that exceeds the limit.");
        });
    }

}