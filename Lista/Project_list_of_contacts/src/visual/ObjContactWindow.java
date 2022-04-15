package visual;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Contact;

public class ObjContactWindow extends JButton implements ActionListener{

	 private Color backgroundJText = new Color(105,105,105);
	   
	    private JLabel labelTitle = new JLabel();
	    private JLabel labelIndex = new JLabel();
	    protected JButton btnEdit = new JButton();
	    protected JButton btnDelete = new JButton();
	    private String name;
	    private String phone;
	    private boolean delete;
	    private boolean editar;
	    private int idLocal = 0;

	    @Override
	    public void actionPerformed(ActionEvent actionEvent) {
	        
	    }
	
	
	public ObjContactWindow(int y, Contact contact){
       
        btnDelete.setBounds(500,1,30,30);
        btnDelete.setBackground(new Color(105,105,105));
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(this);
        add(btnDelete);

        btnEdit.setBounds(532,1,30,30);
        btnEdit.setBackground(new Color(105,105,105));
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(this);
        add(btnEdit);

        labelTitle.setBounds(50,5,450,20);
        labelTitle.setForeground(new Color(220,220,220));
        labelTitle.setText("("+name+") "+phone);
        add(labelTitle);

        labelIndex.setBounds(10,5,450,20);
        labelIndex.setForeground(new Color(220,220,220));
        labelIndex.setText(""+(y+1));
        add(labelIndex);

        setLayout(null);
        setBounds(0, 2+(y*32),600,30);
        setBorder(new LineBorder(new Color(105,105,105), 2));
        setBackground(new Color(105,105,105));
        addActionListener(this);
        repaint();
    }
	
}
