import java.io.Serializable;
public class Estudiantes implements Serializable {
    private String nombre;
    private String contra;

    public Estudiantes(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Estudiantes() {
    }

}
