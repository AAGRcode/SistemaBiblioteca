package ec.edu.ups.sistemabiblioteca.clases;

/**
 *
 * @author AAGR
 */
public class Persona {
    private String nombreCompleto;
    private int edad;
    private String cedula;

    public Persona() {
    }

    public Persona(String nombreCompleto, int edad, String cedula) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", cedula=" + cedula + '}';
    }
    
    
    
}
