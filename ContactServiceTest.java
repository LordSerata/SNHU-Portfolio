package com.example.contactservice.test;

import com.example.contactservice.Contact;
import com.example.contactservice.ContactService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(1, service.getContacts().size());
    }

    @Test
    public void testAddContactWithDuplicateIdFails() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
        assertEquals("Duplicate contact ID", exception.getMessage());
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertEquals(0, service.getContacts().size());
    }

    @Test
    public void testUpdateContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        Contact updatedContact = service.getContacts().get(0);
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
}
