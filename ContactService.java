package com.example.contactservice;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    // Add a contact with unique contactID
    public void addContact(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getContactID().equals(contact.getContactID())) {
                throw new IllegalArgumentException("Duplicate contact ID");
            }
        }
        contacts.add(contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        contacts.removeIf(contact -> contact.getContactID().equals(contactID));
    }

    // Update contact by ID
    public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                contact.setFirstName(newFirstName);
                contact.setLastName(newLastName);
                contact.setPhone(newPhone);
                contact.setAddress(newAddress);
            }
        }
    }

    // Getter for contacts (for testing purposes)
    public List<Contact> getContacts() {
        return contacts;
    }
}