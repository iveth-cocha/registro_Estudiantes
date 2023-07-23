import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Principal {
    private JPanel rootPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton inicioButton;
    private JButton registroButton;

    //get que hace posible la invocacion a esta ventana registro
    public JPanel getRootPanel() {
        return rootPanel;
    }




    public Principal() {
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Instancio
                Registro v2 = new Registro();

                JFrame frameR = new JFrame("Registro");

                frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameR.setResizable(false);
                frameR.setPreferredSize(new Dimension(500,400));
                frameR.pack();
                frameR.setLocationRelativeTo(null);
                frameR.setVisible(true);

                //direcciona a mi ventana registro
                frameR.setContentPane(v2.getRootPanel2());

            }
        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_ingreso();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Página Inicial");
        frame.setContentPane(new Principal().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //establecer tamaño
        frame.setPreferredSize(new Dimension(500,400));
        frame.pack();
        //establecer posicion central
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    //llamar ventana por metodo
    public void ventana_ingreso(){
        Ingreso v1 = new Ingreso();

        JFrame frameL = new JFrame("Ingreso");

        frameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameL.setResizable(false);
        frameL.setPreferredSize(new Dimension(500,400));
        frameL.pack();
        frameL.setLocationRelativeTo(null);
        frameL.setVisible(true);

        //direcciona a mi ventana Ingreso
        frameL.setContentPane(v1.getRootPanel1());
    }
}
