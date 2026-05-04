package ec.edu.ups.sistemabiblioteca.clases;

import java.util.Date;

/**
 *
 * @author AAGR
 */
public class PrestamoLibro {
    private static int contadorId = 1;
    private int id;
    private Usuario usuario;
    private Libro libro;
    private Date fechaPedido;
    private Date fechaDevolucion;
    private boolean estado;
    
    public PrestamoLibro(Usuario usuario, Libro libro){
        this.id = contadorId++;
        this.usuario = usuario;
        this.libro= libro;
        this.estado = false;
    }

    public void registrarPrestamo(){
        this.estado=true;
        libro.setEstadoDisponibilidad(false);
    }
    public PrestamoLibro() {
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        PrestamoLibro.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean estaAtrasado(Date hoy){
        if(!estado || fechaDevolucion == null){
            return false;
        }
        return hoy.after(fechaDevolucion);
    }
     
}

     

   

