import java.util.List;

public class TestTexto{
	public static void main(String[] args){
		List<Contact> listOfContacts = DataBaseSimulator.getAllContacts();
		DataBaseSimulator.save(new Contact("Bruna", "(32)3251-9787"));
		listOfContacts = DataBaseSimulator.getAllContacts();
		for(Contact contact : listOfContacts){
			System.out.println(contact.getId()+") "+contact.getName()+" -> "+contact.getPhone());
		}
		//DataBaseSimulator.save(new Contact("Carlos", "(32)3333-9871"));
	}
}
			
