import java.util.HashMap;
import java.util.Map;
//Daniel Jones 3-3 ContactService.java CS 320
public class ContactService {
    private Map<String, Contact> contactMap;

    // Constructor to initialize the service
    public ContactService() {
        this.contactMap = new HashMap<>();
    }

    // Add a contact to the service
    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    // Delete a contact by its contactId
    public void deleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contactMap.remove(contactId);
    }

    // Update a contact's details by contactId
    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        // Update fields
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phoneNumber != null) contact.setphoneNumber(phoneNumber);
        if (address != null) contact.setAddress(address);
    }

    // Get a contact by contactId
    public Contact getContact(String contactId) {
        return contactMap.get(contactId);
    }

    // List all contacts
    public void listAllContacts() {
        if (contactMap.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contactMap.values()) {
                System.out.println(contact);
                System.out.println("--------------------------------");
            }
        }
    }
}