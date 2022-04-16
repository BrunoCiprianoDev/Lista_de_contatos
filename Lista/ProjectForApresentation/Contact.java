package entities;

import java.util.Objects;

public class Contact implements Comparable<Contact>{
	private int id=0;
	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public Contact(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public int compareTo(Contact contact) {
		return this.name.compareTo(contact.getName());
	}
	
}
