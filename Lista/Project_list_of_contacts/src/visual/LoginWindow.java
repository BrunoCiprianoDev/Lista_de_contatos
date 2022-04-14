package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;

import repository.LoginRepository;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Key;

public class LoginWindow extends JFrame implements ActionListener{
	 private Panel painel = new Panel();
	    private Color backgroundJText = new Color(105,105,105);
	    private Color fontTextColor = new Color(220,220,220);
	    private Color cinzaEscuro = new Color(55,55,55);
	    private JTextField usuario = new JTextField();
	    private JPasswordField senha = new JPasswordField();
	    private JLabel textoUsuario = new JLabel("Usuario:");
	    private JLabel textoSenha = new JLabel("Senha:");
	    private JLabel textoInformativo = new JLabel("Informe o usuario e senha do banco de dados:");
	    private JButton btnLogar = new JButton("Login");
	
	    public void actionPerformed(ActionEvent e){
	    	if(e.getSource()==btnLogar){
	    		String strUsuario = usuario.getText();
	    		String strSenha = String.valueOf(senha.getPassword());
	    		Key key = new Key(strUsuario, strSenha);
	    		
	    		if(LoginRepository.testConnection(key)){
	    			setVisible(false);
	              }
	        }
	    }
    
	    public LoginWindow(){

	        btnLogar.setBounds(140,135, 100,20);
	        btnLogar.setBackground(backgroundJText);
	        btnLogar.setForeground(fontTextColor);
	        btnLogar.setBorder(new LineBorder(backgroundJText, 2));
	        btnLogar.addActionListener(this);
	        painel.add(btnLogar);

	        textoInformativo.setBounds(30,10, 350,20);
	        textoInformativo.setForeground(fontTextColor);
	        painel.add(textoInformativo);

	        textoUsuario.setBounds(50,35, 100,20);
	        textoUsuario.setForeground(fontTextColor);
	        painel.add(textoUsuario);

	        textoSenha.setBounds(50,85, 100,20);
	        textoSenha.setForeground(fontTextColor);
	        painel.add(textoSenha);

	        usuario.setBounds(50,55,290,20);
	        usuario.setBackground(backgroundJText);
	        usuario.setForeground(fontTextColor);
	        usuario.setBorder(new LineBorder(backgroundJText, 2));
	        painel.add(usuario);

	        senha.setBounds(50,105,290,20);
	        senha.setBackground(backgroundJText);
	        senha.setForeground(fontTextColor);
	        senha.setBorder(new LineBorder(backgroundJText, 2));
	        painel.add(senha);

	        setLayout(null);
	        setTitle("Login");
	        setSize(400,200);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);

	        painel.setLayout(null);
	        painel.setBackground(cinzaEscuro);
	        painel.setBounds(0,0,400,500);
	        add(painel);
	    }
}
