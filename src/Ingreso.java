import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ingreso {
    private JPanel rootPanel1;
    private JTextArea mostrar;
    private JButton salirButton;

    public JPanel getRootPanel1() {
        return rootPanel1;
    }

    public Ingreso() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_Principal();
            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Ingreso().rootPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void ventana_Principal(){
        Principal v = new Principal();

        JFrame frameINI= new JFrame("Página Inicial");

        frameINI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameINI.setResizable(false);
        frameINI.setPreferredSize(new Dimension(500,400));
        frameINI.pack();
        frameINI.setLocationRelativeTo(null);
        frameINI.setVisible(true);

        //direcciona a mi ventana Principal
        frameINI.setContentPane(v.getRootPanel());
    }
}
