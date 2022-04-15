package visual;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DeletePane extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private JPanel painel = new JPanel();
    private JLabel labelTexto = new JLabel("Quer mesmo deletar essa tarefa?");
    protected JButton btnConfirmar  = new JButton("Sim");
    protected JButton btnNegar  = new JButton("Não");

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

        btnConfirmar.setBounds(70,105, 100,20);
        btnConfirmar.setBackground(new Color(105,105,105));
        btnConfirmar.setForeground( new Color(220,220,220));
        btnConfirmar.setBorder(new LineBorder(new Color(105,105,105), 2));
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setFocusPainted(false);
        painel.add(btnConfirmar);

        btnNegar.setBounds(220,105, 100,20);
        btnNegar.setBackground(new Color(105,105,105));
        btnNegar.setForeground(new Color(220,220,220));
        btnNegar.setBorder(new LineBorder(new Color(105,105,105), 2));
        btnNegar.setBorderPainted(false);
        btnNegar.setFocusPainted(false);
        painel.add(btnNegar);

        painel.setLayout(null);
        painel.setBounds(0,0,400, 180);
        painel.setBackground(new Color(55,55,55));
        painel.add(btnConfirmar);
        add(painel);

    }
}
