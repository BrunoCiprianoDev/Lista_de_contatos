package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import entities.Contact;

import java.awt.*;
import java.text.ParseException;

public class NewContactWindow extends JFrame{

    private static final long serialVersionUID = 1L;
	private Color cinzaEscuro = new Color(55,55,55);
    private Color cinzaClaro = new Color(105,105,105);
    private Color cinzaFonte = new Color(220,220,220);
    private Font fonte = new Font("Roboto", Font.BOLD,15);
    private JPanel painel = new JPanel();
    private JLabel lbTitulo = new JLabel("Insira uma data e um titulo para a tarefa:");
    protected JTextField areaPhone;
    protected JTextArea areaName = new JTextArea();
    protected JButton btnSalvar = new JButton("Salvar");
    protected JButton btnCancelar = new JButton("Cancelar");

    public NewContactWindow() {

        btnCancelar.setBounds(300,130,100,20);
        btnCancelar.setBackground(cinzaClaro);
        btnCancelar.setForeground(cinzaFonte);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        painel.add(btnCancelar);

        btnSalvar.setBounds(160,130,100,20);
        btnSalvar.setBackground(cinzaClaro);
        btnSalvar.setForeground(cinzaFonte);
        btnSalvar.setBorderPainted(false);
        btnSalvar.setFocusPainted(false);
        painel.add(btnSalvar);

        lbTitulo.setBounds(65,20, 400,20);
        lbTitulo.setForeground(cinzaFonte);
        painel.add(lbTitulo);

        areaName.setBounds(65, 90, 450, 20);
        areaName.setForeground(cinzaFonte);
        areaName.setBackground(cinzaClaro);
        areaName.setFont(fonte);
        painel.add(areaName);

        MaskFormatter maskNumber = null;
        try {
            maskNumber = new MaskFormatter("(##)#####-####");
            maskNumber.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        areaPhone = new JFormattedTextField(maskNumber);
        areaPhone.setBounds(65, 50, 80, 20);
        areaPhone.setBorder(new LineBorder(cinzaClaro, 2));
        areaPhone.setForeground(cinzaFonte);
        areaPhone.setBackground(cinzaClaro);
        areaPhone.setFont(fonte);
        painel.add(areaPhone);

        painel.setBackground(cinzaEscuro);
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
