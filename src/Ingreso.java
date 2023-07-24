import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ingreso  {
    public JPanel rootPanel1;
    private JButton salirButton;
    public JTextField visualizar;
    JPanel rootPanel;

    public JPanel getRootPanel1() {
        return rootPanel1;
    }

    public Ingreso() {

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame framep;
                framep = (JFrame) SwingUtilities.getWindowAncestor(rootPanel1);
                framep.setVisible(false);

                Principal v = new Principal();

                JFrame frameINI= new JFrame("Página Inicial");
                Principal vprinc = new Principal();

                frameINI.setContentPane(vprinc.rootPanel);
                frameINI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameINI.setResizable(false);
                frameINI.setPreferredSize(new Dimension(500,400));
                frameINI.pack();
                frameINI.setLocationRelativeTo(null);
                frameINI.setVisible(true);

            }
        });
    }


}
