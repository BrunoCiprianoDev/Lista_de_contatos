import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

class Program {
	public static void main(String[] args) {		
		new MainWindow();
		//consoleApplication.runTerminal(new Scanner(System.in));
	}
}




class ObjContactWindow extends JButton implements ActionListener{
	   
	    private static final long serialVersionUID = 1L;
	    private ImageIcon imgEdit = new ImageIcon(getClass().getResource("icons/editImage.png"));
            private ImageIcon imgDelete = new ImageIcon(getClass().getResource("icons/wasteImage.png"));
	    private JLabel labelTitle = new JLabel();
	    private JLabel labelIndex = new JLabel();
	    protected JButton btnEdit = new JButton();
	    protected JButton btnDelete = new JButton();
	    private boolean delete;
	    private boolean edit;
	    private String name;
	    private String phone;
	    private int idLocal = 0;
	    private int idDB = 0;

	    @Override
	    public void actionPerformed(ActionEvent actionEvent) {
	        if(actionEvent.getSource()==btnDelete){
	            this.delete = true;
	        }
	        if(actionEvent.getSource()==btnEdit){
	            this.edit = true;
	        }   	
	    }
	    
	public ObjContactWindow(int y, int idDB, String name, String phone){
		this.name = name;
		this.phone = phone;
		this.idLocal = y;
        this.idDB = idDB;
        this.delete = false;
        this.edit = false;
        
        btnDelete.setBounds(552,-1,30,30);
        btnDelete.setIcon(imgDelete);
        btnDelete.setBackground(new Color(105,105,105));
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(this);
        add(btnDelete);

        btnEdit.setBounds(500,-9,50,50);
        btnEdit.setBackground(new Color(105,105,105));
        btnEdit.setIcon(imgEdit);
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(this);
        add(btnEdit);

        labelTitle.setBounds(50,5,450,20);
        labelTitle.setForeground(new Color(220,220,220));
        labelTitle.setText(" "+name+": "+phone);
        add(labelTitle);

        labelIndex.setBounds(10,5,450,20);
        labelIndex.setForeground(new Color(220,220,220));
        labelIndex.setText(""+(y+1));
        add(labelIndex);

        addActionListener(this);
        setLayout(null);
        setBounds(0, 2+(y*32),600,30);
        setBorder(new LineBorder(new Color(105,105,105), 2));
        setBackground(new Color(105,105,105));
        repaint();
    }
	
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isEdit() {
		return this.edit;
	}
	public void setEdit(boolean editar) {
		this.edit = editar;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	
	public int getIdDB() {
		return this.idDB;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getName() {
		return this.name;
	}
	
}


class NewContactWindow extends JFrame{

    private static final long serialVersionUID = 1L;
    private Font font = new Font("Roboto", Font.BOLD,15);
    private JPanel painel = new JPanel();
    private JLabel lbTitle = new JLabel("Insira uma data e um titulo para a tarefa:");
    protected JTextField areaPhone;
    protected JTextArea areaName = new JTextArea();
    protected JButton btnSave = new JButton("Salvar");
    protected JButton btnCancel = new JButton("Cancelar");

    public NewContactWindow() {

        btnCancel.setBounds(300,130,100,20);
        btnCancel.setBackground(new Color(105,105,105));
        btnCancel.setForeground(new Color(220,220,220));
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        painel.add(btnCancel);

        btnSave.setBounds(160,130,100,20);
        btnSave.setBackground(new Color(105,105,105));
        btnSave.setForeground(new Color(220,220,220));
        btnSave.setBorderPainted(false);
        btnSave.setFocusPainted(false);
        painel.add(btnSave);

        lbTitle.setBounds(65,20, 400,20);
        lbTitle.setForeground(new Color(220,220,220));
        painel.add(lbTitle);

        areaName.setBounds(65, 90, 450, 20);
        areaName.setForeground(new Color(220,220,220));
        areaName.setBackground(new Color(105,105,105));
        areaName.setFont(font);
        painel.add(areaName);

        MaskFormatter maskNumber = null;
        try {
            maskNumber = new MaskFormatter("(##)####-####");
            maskNumber.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        areaPhone = new JFormattedTextField(maskNumber);
        areaPhone.setBounds(65, 50, 140, 20);
        areaPhone.setBorder(new LineBorder(new Color(105,105,105), 2));
        areaPhone.setForeground(new Color(220,220,220));
        areaPhone.setBackground(new Color(105,105,105));
        areaPhone.setFont(font);
        painel.add(areaPhone);

        painel.setBackground(new Color(55,55,55));
        painel.setBounds(0, 0, 600, 200);
        painel.setLayout(null);
        add(painel);

        setLayout(null);
        setTitle("Novo contato:");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }
    public NewContactWindow(Contact oldContact){
        new NewContactWindow();
        areaName.setText(oldContact.getName());
        areaPhone.setText(oldContact.getPhone());
    }
}



class DeletePane extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private JPanel painel = new JPanel();
    private JLabel labelTexto = new JLabel("Quer mesmo deletar essa tarefa?");
    protected JButton btnConfirm  = new JButton("Sim");
    protected JButton btnDecline  = new JButton("Não");

    public DeletePane(){

        setLayout(null);
        setTitle("Login");
        setSize(400,180);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        labelTexto.setBounds(75,20,300,40);
        labelTexto.setForeground(new Color(220,220,220));
        painel.add(labelTexto);

        btnConfirm.setBounds(70,105, 100,20);
        btnConfirm.setBackground(new Color(105,105,105));
        btnConfirm.setForeground( new Color(220,220,220));
        btnConfirm.setBorder(new LineBorder(new Color(105,105,105), 2));
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        painel.add(btnConfirm);

        btnDecline.setBounds(220,105, 100,20);
        btnDecline.setBackground(new Color(105,105,105));
        btnDecline.setForeground(new Color(220,220,220));
        btnDecline.setBorder(new LineBorder(new Color(105,105,105), 2));
        btnDecline.setBorderPainted(false);
        btnDecline.setFocusPainted(false);
        painel.add(btnDecline);

        painel.setLayout(null);
        painel.setBounds(0,0,400, 180);
        painel.setBackground(new Color(55,55,55));
        painel.add(btnConfirm);
        add(painel);

    }
}

class DataBaseSimulator{
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

class Contact implements Comparable<Contact>{
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

class MainWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	private JPanel painel = new JPanel();
    private JScrollPane scrollPane;
    private JToolBar header = new JToolBar();
    private JButton btnAdd = new JButton("Adicionar");
	private List<ObjContactWindow> listOfContactsView = new ArrayList<>();;
    private int indexList=0;
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==btnAdd){
        	NewContactWindow newContactWindow = new NewContactWindow();
            newContactWindow.btnSave.addMouseListener(
                    new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            String phoneInsert = newContactWindow.areaPhone.getText();
                            String nameInsert = newContactWindow.areaName.getText();
                                DataBaseSimulator.save(new Contact(nameInsert, phoneInsert));
                                newContactWindow.dispose();
                                updatePainel();
                            }
                        }
                    );
        }
    }
    
    private void updatePainel() {
    	painel.removeAll();
    	repaint();
    	updateToDB();
    }
    
    private void updateToDB(){
		indexList=0;
	        List<Contact> listOfContacts = DataBaseSimulator.getAllContacts();
	        Collections.sort(listOfContacts);
	        listOfContactsView.clear();
	        for(Contact contact: listOfContacts){
	            listOfContactsView.add(new ObjContactWindow(indexList, contact.getId(), contact.getName(), contact.getPhone()));
	            painel.add(listOfContactsView.get(indexList));
	            listOfContactsView.get(indexList).btnDelete.addMouseListener(
	                    new MouseAdapter() {
	                        public void mouseReleased(MouseEvent e) {
	                            verifyItemsListDelete();
	                        }
	                    });
	            listOfContactsView.get(indexList).btnEdit.addMouseListener(
	                    new MouseAdapter() {
	                        public void mouseReleased(MouseEvent e) {
	                            verifyItemsListEdit();
	                        }
	                    });
	            ++indexList;
	        }
	        repaint();
	}
    
    private void verifyItemsListDelete(){
        for(ObjContactWindow objContactWindow : listOfContactsView){
            boolean delete = objContactWindow.isDelete();
            if(delete){
                for(int i=0; i<(indexList-1); i++){
                    listOfContactsView.get(i).setDelete(false);
                }
                DeletePane deletePane = new DeletePane();
                deletePane.btnConfirm.addMouseListener(
                        new MouseAdapter() {
                            public void mouseReleased(MouseEvent e) {
                                DataBaseSimulator.delete(objContactWindow.getIdDB());
                                deletePane.dispose();
                                updatePainel();
                            }
                        });
                deletePane.btnDecline.addMouseListener(
                        new MouseAdapter() {
                            public void mouseReleased(MouseEvent e) {
                                deletePane.dispose();
                                updatePainel();
                            }
                        });
            }
        }
    }
    
    private void verifyItemsListEdit(){
        for(ObjContactWindow objContactWindow : listOfContactsView){
            boolean edit = objContactWindow.isEdit();
            if(edit){
                for(int i=0; i<(indexList); i++){
                	listOfContactsView.get(i).setEdit(false);
                }
                NewContactWindow newContactWindow = new NewContactWindow();
                newContactWindow.setTitle("Editar contato:");
                newContactWindow.areaPhone.setText(objContactWindow.getPhone());
                newContactWindow.areaName.setText(objContactWindow.getName());
                newContactWindow.btnSave.addMouseListener(     
                		new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                String phoneInsert = newContactWindow.areaPhone.getText();
                                String nameInsert = newContactWindow.areaName.getText();
                                    DataBaseSimulator.update(objContactWindow.getIdDB(), new Contact(nameInsert, phoneInsert));
                                    newContactWindow.dispose();
                                    updatePainel();
                                }
                            }
                        );
                newContactWindow.btnCancel.addMouseListener(
                        new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                for(int i=0; i<(indexList); i++){
                                	listOfContactsView.get(i).setEdit(false);
                                }
                                newContactWindow.dispose();
                            }
                            
                        });
            }}
        }
   
	public MainWindow() {
			updateToDB();
		    btnAdd.setBounds(0,0,100,20);
	        btnAdd.setBackground(new Color(105,105,105));
	        btnAdd.setForeground(new Color(220,220,200));
	        btnAdd.setBorderPainted(false);
	        btnAdd.setFocusPainted(false);
	        btnAdd.addActionListener(this);

	        header.setBounds(0,0,620,20);
	        header.setBorder(new LineBorder(new Color(105,105,105), 2));
	        header.setBackground(new Color(105,105,105));
	        header.setLayout(null);
	        header.add(btnAdd);

	        setLayout(null);
	        setTitle("Lista de contatos:");
	        setSize(600,700);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);
	        add(header);

	        painel.setBackground(new Color(55,55,55));
	        painel.setPreferredSize(new Dimension(580,700));
	        painel.setLayout(null);

	        scrollPane = new JScrollPane(painel);
	        scrollPane.setBounds(0,20,620,700);
	        scrollPane.setBorder(new LineBorder(new Color(105,105,105), 2));
	        add(scrollPane);
	}
}

