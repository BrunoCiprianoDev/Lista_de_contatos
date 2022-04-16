package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entities.Contact;
import repository.ContactRepository;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainWindow extends JFrame implements ActionListener {

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
                                ContactRepository.save(new Contact(nameInsert, phoneInsert));
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
	        List<Contact> listOfContacts = ContactRepository.getAllContacts();
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
                                ContactRepository.delete(objContactWindow.getIdDB());
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
                                    ContactRepository.update(objContactWindow.getIdDB(), new Contact(nameInsert, phoneInsert));
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
