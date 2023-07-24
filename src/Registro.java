import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Registro {
    public JPanel rootPanel2;
    private JTextField nom_re;
    private JPasswordField ps1;
    private JButton registrarseButton;

    JPanel rootPanel;

public Registro() {
    registrarseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //---------Registrar usuario___________________

            Estudiantes registro = new Estudiantes();
            String nombre = nom_re.getText();
            registro.setNombre(nombre);
            String contra=String.valueOf(ps1.getPassword());
            registro.setContra(contra);

            try{

                FileOutputStream nombreR = new FileOutputStream("Usuario.dat",true);
                ObjectOutputStream objd = new ObjectOutputStream(nombreR);
                objd.writeObject(registro);
                System.out.println("Registro exitoso! ");
                nom_re.setText("");
                ps1.setText("");
            } catch (FileNotFoundException ex) {
                System.out.println("NO SE ENCUENTRA EL ARCHIVO " + ex);
            } catch (IOException ex) {
                System.out.println("NO SE PUDO GUARDAR EL ARCHIVO" +ex);
            }


            //----------reegresar a ventana principal------------------

            JFrame frameIni = (JFrame) SwingUtilities.getWindowAncestor(rootPanel2);
            frameIni.setVisible(false);

            JFrame princfr= new JFrame("Página Inicial");
            Principal vpri = new Principal();

            princfr.setContentPane(vpri.rootPanel);
            princfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            princfr.setResizable(false);
            princfr.setPreferredSize(new Dimension(500,400));
            princfr.pack();
            princfr.setLocationRelativeTo(null);
            princfr.setVisible(true);

        }
    });
}


}
