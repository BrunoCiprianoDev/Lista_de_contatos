package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DeletePane extends JFrame{

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
