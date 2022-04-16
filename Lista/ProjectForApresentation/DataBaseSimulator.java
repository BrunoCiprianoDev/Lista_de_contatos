
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class DataBaseSimulator{
	public static List<Contact> getAllContacts(){
		List<Contact> listOfContacts = new ArrayList<>();
        	File file = new File("listOfContacts.txt");
        	try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
            	String line;
		int index=0;
            	while((line=br.readLine())!=null){
				++index;
                		String[] partes = line.split("!");
                		Integer id = Integer.parseInt(partes[0]);
                		listOfContacts.add(new Contact(index, partes[1], partes[2] ));
            		}

        	}catch(IOException e){
            		e.printStackTrace();
        	}
       		return listOfContacts;
	}		

	public static void save(Contact contact){
		List<Contact> listOfContacts = getAllContacts();
		listOfContacts.add(contact);
		File file = new File("listOfContacts.txt");
		try(FileWriter fr = new FileWriter(file); BufferedWriter br = new BufferedWriter(fr)){
                	String line;
			int id = 0;
                	for(Contact contactGeneric : listOfContacts){
				id++;
				br.write(id+"!"+contactGeneric.getName()+"!"+contactGeneric.getPhone());
				br.newLine();
			}

                }catch(IOException e){
                        e.printStackTrace();
                }
        }

	public static void delete(int index){
		List<Contact> listOfContacts = getAllContacts();
		listOfContacts.remove(--index);
		File file = new File("listOfContacts.txt");
                try(FileWriter fr = new FileWriter(file); BufferedWriter br = new BufferedWriter(fr)){
                        String line;
                        int id = 0;
                        for(Contact contactGeneric : listOfContacts){
                                id++;
                                br.write(id+"!"+contactGeneric.getName()+"!"+contactGeneric.getPhone());
                                br.newLine();
                        }

                }catch(IOException e){
                        e.printStackTrace();
                }
	}

	public static void update(int id, Contact contact){
		delete(id);
		save(contact);	
	}
}

