package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    private JPanel painel = new JPanel();
    private JScrollPane scrollPane;
    private JToolBar header = new JToolBar();
    private JButton btnAdicionar = new JButton("Adicionar");
	
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==btnAdicionar){
           
        }
    }
	
	public MainWindow() {
		    btnAdicionar.setBounds(0,0,100,20);
	        btnAdicionar.setBackground(new Color(105,105,105));
	        btnAdicionar.setForeground(new Color(220,220,200));
	        btnAdicionar.setBorderPainted(false);
	        btnAdicionar.setFocusPainted(false);
	        btnAdicionar.addActionListener(this);

	        header.setBounds(0,0,620,20);
	        header.setBorder(new LineBorder(new Color(105,105,105), 2));
	        header.setBackground(new Color(105,105,105));
	        header.setLayout(null);
	        header.add(btnAdicionar);

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
