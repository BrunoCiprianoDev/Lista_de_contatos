import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ObjContactWindow extends JButton implements ActionListener{
	   
	    private static final long serialVersionUID = 1L;
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
        
        btnDelete.setBounds(552,-8,50,50);
        btnDelete.setText("X");
        btnDelete.setBackground(new Color(105,105,105));
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(this);
        add(btnDelete);

        btnEdit.setBounds(500,-9,50,50);
        btnEdit.setBackground(new Color(105,105,105));
        btnEdit.setText("E");
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
