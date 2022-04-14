package application;

import visual.LoginWindow;

public class Program {
	public static void main(String[] args) {
		//ContactRepository.save(new Contact("Mario", "(32)3251-9789"));
		//ContactRepository.update(1, new Contact("Bruno Cipriano", "(32)988239585"));
		//ContactRepository.testConnection();
		//List<Contact> listOfContact = ContactRepository.getAllContacts();
		//for(Contact contact : listOfContact) {
		//	System.out.println(contact.getId()+") Nome: "+contact.getName()+" --> Contato: "+contact.getPhone());
		//}
		new LoginWindow();
	}
}
 