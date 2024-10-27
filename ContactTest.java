package com.example.contactservice.test;

import com.example.contactservice.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test creating a contact successfully
    @Test
    public void testCreateContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testCreateContactContactIdFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testCreateContactFirstNameTooLongFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnathanIsHereLong", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testCreateContactFirstNameNullFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testCreateContactLastNameTooLongFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeJohnIsHereLong", "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testCreateContactAddressTooLongFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "123 This Address is Too Long For The Requirement Specification");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    public void testCreateContactNumberTooShortFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testCreateContactNumberTooLongFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890123", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testCreateContactPhoneNotDigitFails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345abcde", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
}