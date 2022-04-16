package test;

import repository.ContactRepository;
import entities.Contact;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class consoleApplication {
	public static void runTerminal() {
		int index = 0;
		List<Contact> listOfContacts = ContactRepository.getAllContacts();
		Collections.sort(listOfContacts);
		for(Contact contact : listOfContacts) {
			System.out.println((++index)+")"+contact.getName()+": "+contact.getPhone());
		}
		System.out.println("+-----------------------+");
		System.out.println("|Escolha uma opção:     |");
		System.out.println("+-----------------------+");
		System.out.println("|1)Novo contato         |");
		System.out.println("|2)Editar contato       |");
		System.out.println("|3)Deletar contato      |");
		System.out.println("|4)Sair                 |");
		System.out.println("+-----------------------+");
		int choice = new Scanner(System.in).nextInt();
		switch(choice) {
			case 1:
				addContact();	
				break;
				
			case 2:
				editContact(listOfContacts);
				break;
			case 3:
				deleteContact(listOfContacts);
				break;
			
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
		listOfContacts.clear();
		runTerminal();
	}
	
	private static void addContact() {
		Scanner scannerAdd = new Scanner(System.in);
		System.out.println("Insira o nome do novo contato:");
		String name = scannerAdd.next();
		System.out.println("Insira o nome do novo contato:(##)####-####");
		String phone = scannerAdd.next();
		ContactRepository.save(new Contact(name, phone));
		//scannerAdd.close();
	}
	
	public static void editContact(List<Contact> listOfContacts) {
		String name;
		String phone;
		Scanner scannerEdit = new Scanner(System.in);
		System.out.println("Insira o id do contato que deseja modificar:");
		int id = scannerEdit.nextInt();
		Contact contactForEdit = listOfContacts.get((id-1));
		System.out.println("Nome: "+contactForEdit.getName());
		System.out.println("Telefone: "+contactForEdit.getPhone());
		System.out.println("Informe qual campo deseja modificar:");
		System.out.println(" 1)Nome \n 2)Telefone \n 3)Ambos os campos");
		int choice = scannerEdit.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Informe o novo nome:");
			name = scannerEdit.next();
			contactForEdit.setName(name);
			ContactRepository.update(contactForEdit.getId(), contactForEdit);
			break;
		case 2:
			System.out.println("Informe o novo telefone:(##)####-####");
			phone = scannerEdit.next();
			contactForEdit.setPhone(phone);
			ContactRepository.update(contactForEdit.getId(), contactForEdit);
			break;
		case 3:
			System.out.println("Informe o novo nome:");
			name = scannerEdit.next();
			scannerEdit.nextLine();
			contactForEdit.setName(name);
			System.out.println("Informe o novo telefone:(##)####-####");
			phone = scannerEdit.next();
			contactForEdit.setPhone(phone);
			ContactRepository.update(contactForEdit.getId(), contactForEdit);
			break;
		default:
			System.out.println("Opção inválida!");
		}	
		//scannerEdit.close();
	}	
	public static void deleteContact(List<Contact> listOfContacts) {
		Scanner scannerDelete = new Scanner(System.in);
		System.out.println("Insira o id do contato que deseja deletar:");
		int id = scannerDelete.nextInt();
		Contact contactForDelete = listOfContacts.get((id-1));
		ContactRepository.delete(contactForDelete.getId());
		//scannerDelete.close();
	}
}
