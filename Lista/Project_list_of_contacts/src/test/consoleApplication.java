package test;

import repository.ContactRepository;
import entities.Contact;
import entities.Key;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class consoleApplication {
	public static void runTerminal(Scanner scanner) {
		System.out.println("Insira a senha de root para o banco de dados:");
		String keyPass = scanner.next();
		Key key = new Key("root", keyPass);
		
		int index = 0;
		List<Contact> listOfContacts = ContactRepository.getAllContacts(key);
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
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				addContact(key, scanner);	
				break;
			case 2:
				editContact(key, scanner, listOfContacts);
				break;
			case 3:
				deleteContact(key, scanner, listOfContacts);
				break;	
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
		listOfContacts.clear();
		runTerminal(scanner);
	}
	
	private static void addContact(Key key, Scanner scanner) {
		System.out.println("Insira o nome do novo contato:");
		String name = scanner.next();
		System.out.println("Insira o nome do novo contato:(##)####-####");
		String phone = scanner.next();
		ContactRepository.save(key, new Contact(name, phone));
	}
	
	public static void editContact(Key key, Scanner scanner, List<Contact> listOfContacts) {
		String name;
		String phone;
		System.out.println("Insira o id do contato que deseja modificar:");
		int id = scanner.nextInt();
		Contact contactForEdit = listOfContacts.get((id-1));
		System.out.println("Nome: "+contactForEdit.getName());
		System.out.println("Telefone: "+contactForEdit.getPhone());
		System.out.println("Informe qual campo deseja modificar:");
		System.out.println(" 1)Nome \n 2)Telefone \n 3)Ambos os campos");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Informe o novo nome:");
			name = scanner.next();
			contactForEdit.setName(name);
			ContactRepository.update(key, contactForEdit.getId(), contactForEdit);
			break;
		case 2:
			System.out.println("Informe o novo telefone:(##)####-####");
			phone = scanner.next();
			contactForEdit.setPhone(phone);
			ContactRepository.update(key, contactForEdit.getId(), contactForEdit);
			break;
		case 3:
			System.out.println("Informe o novo nome:");
			name = scanner.next();
			scanner.nextLine();
			contactForEdit.setName(name);
			System.out.println("Informe o novo telefone:(##)####-####");
			phone = scanner.next();
			contactForEdit.setPhone(phone);
			ContactRepository.update(key, contactForEdit.getId(), contactForEdit);
			break;
		default:
			System.out.println("Opção inválida!");
		}	
	}	
	public static void deleteContact(Key key, Scanner scanner, List<Contact> listOfContacts) {
		System.out.println("Insira o id do contato que deseja deletar:");
		int id = scanner.nextInt();
		Contact contactForDelete = listOfContacts.get((id-1));
		ContactRepository.delete(key, contactForDelete.getId());
	}
}
