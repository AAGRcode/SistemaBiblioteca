package ec.edu.ups.sistemabiblioteca.clases;

import ec.edu.ups.sistemabiblioteca.clases.PrestamoLibro;
import java.util.Date;

/**
 *
 * @author AAGR
 */
public class Usuario {
    private Persona datosUsuario;
    private String clave;

    public Usuario() {
    }

    public Usuario(Persona datosUsuario, String clave) {
        this.datosUsuario = datosUsuario;
        this.clave = clave;
    }

    public Persona getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(Persona datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public PrestamoLibro pedirLibro(Libro libro){
        if(!libro.estaDisponible()){
            System.out.println("El libro no esta disponible");
            return null;    
        }
        PrestamoLibro prestamo = new PrestamoLibro(this, libro);
        prestamo.registrarPrestamo();
        return prestamo;
    }

}