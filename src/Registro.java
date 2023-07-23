import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Registro {
    private JPanel rootPanel2;
    private JTextField nom_re;
    private JPasswordField ps1;
    private JButton registrarseButton;

    private ArrayList<Estudiantes>datos;


    //get que hace posible la invocacion a esta ventana registro
    public JPanel getRootPanel2() {
        return rootPanel2;
    }


public Registro() {
    registrarseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //---------Registrar usuario___________________
            datos=new ArrayList();

            String nombre =nom_re.getText();
            String contra = ps1.getText();

            Estudiantes nuevo = new Estudiantes(nombre, contra);
            datos.add(nuevo);

            String filePath = "Usuarios.dat";

            try(
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            ){
                objOut.writeObject(nuevo);
                System.out.println("Archivo guardado correctamente");
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }


            //----------reegresar a ventana principal------------------
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
    });
}


    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro");

        frame.setContentPane(new Registro().rootPanel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
