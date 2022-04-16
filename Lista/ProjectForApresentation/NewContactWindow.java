import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.text.ParseException;

public class NewContactWindow extends JFrame{

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
