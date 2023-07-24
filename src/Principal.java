import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Principal {
    public JPanel rootPanel;
    private JTextField n_user;
    private JPasswordField pas_user;
    private JButton inicioButton;
    private JButton registroButton;

    JPanel rootPanel1;
    JPanel rootPanel2;
    public String username;
    private boolean passw = true;
    private boolean usr;
    private boolean cta;


    public Principal() {
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame prinfr = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                prinfr.setVisible(false);

                JFrame frameR = new JFrame("Registro");
                Registro v2 = new Registro();

                frameR.setContentPane(v2.rootPanel2);
                frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameR.setResizable(false);
                frameR.setPreferredSize(new Dimension(500,400));
                frameR.pack();
                frameR.setLocationRelativeTo(null);
                frameR.setVisible(true);

            }
        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-----------------------Valido los registros
                //verifico credenciales
                username = n_user.getText();
                String password = new String(pas_user.getPassword());
                usr = false;
                cta = false;

                try{

                    FileInputStream dat = new FileInputStream("Usuario.dat");
                    while(passw){
                        ObjectInputStream obIn = new ObjectInputStream(dat);
                        Estudiantes info = (Estudiantes) obIn.readObject();

                        if (info != null){
                            //uso los set de mi clase Estudiante
                            String usuariov = info.getNombre();
                            String contrav = new String(info.getContra());


                            if(username.equals(usuariov) && password.equals(contrav)){
                                System.out.println("ingreso exitoso"); // verifico si se cumple la condicion
                                usr = true;
                                cta = true;
                                break;
                            }
                            else{
                                System.out.println("datos erroneos"); // verifico que pasa si no se cumple
                                n_user.setText("");
                                pas_user.setText("");
                            }
                        }

                        else{
                            passw = false;

                        }
                    }
                    if( usr == true && cta == true){
                        //--------------------Direcciono a la ventana de inicio
                                                                             //ventana a cerrar
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                        frame.setVisible(false);

                        JFrame frameL = new JFrame("Ingreso");
                        Ingreso vingreso = new Ingreso();
                        vingreso.visualizar.setText("Has ingresado tus credenciales correctamente "+username);
                        frameL.setContentPane(vingreso.rootPanel1);//direcciono a la ventana
                        frameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frameL.setPreferredSize(new Dimension(500,400));
                        frameL.pack();
                        frameL.setLocationRelativeTo(null);
                        frameL.setVisible(true);
                    }

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Datos incorretos. Inténtalo de nuevo.");
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Página Inicial");
                frame.setContentPane(new Principal().rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //establecer tamaño
                frame.setPreferredSize(new Dimension(500, 400));
                frame.pack();
                //establecer posicion central
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

}
