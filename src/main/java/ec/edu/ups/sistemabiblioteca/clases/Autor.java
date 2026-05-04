package ec.edu.ups.sistemabiblioteca.clases;

/**
 *
 * @author AAGR
 */
public class Autor {
    private String nombreCompleto;
    private String nacionalidad;
    private int añoNacimiento;

    public Autor() {
    }

    public Autor(String nombreCompleto, String nacionalidad, int anioNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.nacionalidad = nacionalidad;
        this.añoNacimiento = anioNacimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAnioNacimiento() {
        return añoNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.añoNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombreCompleto=" + nombreCompleto + ", nacionalidad=" + nacionalidad + ", anioNacimiento=" + añoNacimiento + '}';
    }
}
