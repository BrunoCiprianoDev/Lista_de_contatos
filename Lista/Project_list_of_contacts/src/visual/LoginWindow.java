package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.Key;

public class LoginWindow extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	private Panel painel = new Panel();
    private Color backgroundJText = new Color(105,105,105);
    private Color fontTextColor = new Color(220,220,220);
    private Color cinzaEscuro = new Color(55,55,55);
    private JTextField user = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JLabel textUser = new JLabel("Usuario:");
    private JLabel textPassword = new JLabel("Senha:");
    private JLabel text = new JLabel("Informe o usuario e senha do banco de dados:");
    private JButton btnLogin = new JButton("Login");


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnLogin){
        	String userPass = user.getText();
            String strPassword = String.valueOf(password.getPassword());
            Key key = new Key(userPass, strPassword);
            setVisible(false);
            new MainWindow(key);
        }

    }

    public LoginWindow(){

        btnLogin.setBounds(140,135, 100,20);
        btnLogin.setBackground(backgroundJText);
        btnLogin.setForeground(fontTextColor);
        btnLogin.setBorder(new LineBorder(backgroundJText, 2));
        btnLogin.addActionListener(this);
        painel.add(btnLogin);

        text.setBounds(30,10, 350,20);
        text.setForeground(fontTextColor);
        painel.add(text);

        textUser.setBounds(50,35, 100,20);
        textUser.setForeground(fontTextColor);
        painel.add(textUser);


        textPassword.setBounds(50,85, 100,20);
        textPassword.setForeground(fontTextColor);
        painel.add(textPassword);

        user.setBounds(50,55,290,20);
        user.setBackground(backgroundJText);
        user.setForeground(fontTextColor);
        user.setBorder(new LineBorder(backgroundJText, 2));
        user.setText("root");
        painel.add(user);

        password.setBounds(50,105,290,20);
        password.setBackground(backgroundJText);
        password.setForeground(fontTextColor);
        password.setBorder(new LineBorder(backgroundJText, 2));
        painel.add(password);

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
