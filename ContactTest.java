// Douglas Bowers
// CS-320
// 6/13/2024
// This class is used to test for the contact class


package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
	
	@BeforeEach
	void setUp() {
		contactId = "12345D289Z";
		firstNameTest = "Robert";
		lastNameTest = "Gray";
		phoneNumberTest = "1112223456";
		addressTest = "5 Street New York NY 15439";
		tooLongContactId = "12345678901234567890";
		tooLongFirstName = "Robert Bobby Ron James";
		tooLongLastName = "Robertson Bobbertson Ronabld Jimmy";
		tooLongPhoneNumber = "111222333444555666";
		tooShortPhoneNumber = "12345";
		tooLongAddress = "5468 Street Drive New York New York NY 12345678";
	}
	
	@Test
	void contactTest() {
		Contact contact = new Contact();
		assertAll("constructor",
				()
					-> assertNotNull(contact.getContactId()),
				()
					-> assertNotNull(contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				()
					-> assertNotNull(contact.getPhoneNumber()),
				()
					-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdConstructorTest() {
		Contact contact = new Contact(contactId);
		assertAll("constructor one",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertNotNull(contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				()
					-> assertNotNull(contact.getPhoneNumber()),
				()
					-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdAndFirstNameConstructorTest() {
		Contact contact = new Contact(contactId, firstNameTest);
		assertAll("constructor two",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				()
					-> assertNotNull(contact.getPhoneNumber()),
				()
					-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdAndFullNameConstructorTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
		assertAll("constructor three",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				()
					-> assertNotNull(contact.getPhoneNumber()),
				()
					-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdFullNamePhoneNumberConstructorTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
		assertAll("constructor four",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				()
					-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				()
					-> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void allCorrectConstructorTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		assertAll("constructor all",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				()
					-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				()
					-> assertEquals(addressTest, contact.getAddress()));
	}
	
	@Test
	void updateFirstNameTest() {
		Contact contact = new Contact();
		contact.updateFirstName(firstNameTest);
		assertAll(
				"first name",
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateFirstName(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateFirstName(tooLongFirstName)));
	}
	
	@Test
	void updateLastNameTest() {
		Contact contact = new Contact();
		contact.updateLastName(lastNameTest);
		assertAll(
				"last name",
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateLastName(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateLastName(tooLongLastName)));
	}
	
	@Test
	void updatePhoneNumberTest() {
		Contact contact = new Contact();
		contact.updatePhoneNumber(phoneNumberTest);
		assertAll(
				"phone number",
				()
					-> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updatePhoneNumber(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updatePhoneNumber(tooLongPhoneNumber)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updatePhoneNumber(tooShortPhoneNumber)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updatePhoneNumber(contactId)));
	}
	
	@Test
	void updateAddressTest() {
		Contact contact = new Contact();
		contact.updateAddress(addressTest);
		assertAll(
				"address",
				()
					-> assertEquals(addressTest, contact.getAddress()),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateAddress(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateAddress(tooLongAddress)));
	}
	
	@Test
	void updateContactIdTest() {
		Contact contact = new Contact();
		contact.updateContactId(contactId);
		assertAll(
				"contact ID",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateContactId(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
								() -> contact.updateContactId(tooLongContactId)));
	}
}
