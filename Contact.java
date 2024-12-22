//Daniel Jones 3-3 Contact.Java CS 320
public class Contact {
    // Private fields to store contact information
    private String contactId;		//Unique Contact ID
    private String firstName;	//First Name of Contact
    private String lastName;	//Last Name of Contact
    private String phoneNumber;	//phoneNumber Number of Contact
    private String address;		//Address of the contact

    	 // Constructor to initialize the contact object with provided information
        public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
            // Validate and set the fields
            if (contactId == null || contactId.length() > 10) {
                throw new IllegalArgumentException("Contact ID must be a non-null string with a maximum length of 10.");
            }
            if (firstName == null || firstName.length() > 10) {
                throw new IllegalArgumentException("First name must be a non-null string with a maximum length of 10.");
            }
            if (lastName == null || lastName.length() > 10) {
                throw new IllegalArgumentException("Last name must be a non-null string with a maximum length of 10.");
            }
            if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d{10}")) {
                throw new IllegalArgumentException("The Phone Number must be exactly 10 digits.");
            }
            if (address == null || address.length() > 30) {
                throw new IllegalArgumentException("Address must be a non-null string with a maximum length of 30.");
            }
    	
    	this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

        // Getter methods for all fields
        public String getContactId() {
            return contactId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getphoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        // Setter methods for updatable fields
        public void setFirstName(String firstName) {
            if (firstName != null && firstName.length() <= 10) {
                this.firstName = firstName;
            } else {
                throw new IllegalArgumentException("First name must be a non-null string with a maximum length of 10.");
            }
        }

        public void setLastName(String lastName) {
            if (lastName != null && lastName.length() <= 10) {
                this.lastName = lastName;
            } else {
                throw new IllegalArgumentException("Last name must be a non-null string with a maximum length of 10.");
            }
        }

    public void setphoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("The Phone Number must be exactly 10 digits.");
        }
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must be a non-null string with a maximum length of 30.");
        }
    }

    // Optional: Override the toString method to display contact information
    @Override
    public String toString() {
        return "Contact ID: " + contactId + "\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Phone: " + phoneNumber + "\n" +
               "Address: " + address;
    }
}