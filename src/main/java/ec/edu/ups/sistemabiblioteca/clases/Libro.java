package ec.edu.ups.sistemabiblioteca.clases;

/**
 *
 * @author AAGR
 */
public class Libro {
    private int id;
    private String titulo;
    private String categoria;
    private int añoPublicacion;
    private boolean estadoDisponibilidad;
    private Autor autor;
    
    public Libro() {
    }

    public Libro(int id, String titulo, String categoria, int añoPublicacion, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.añoPublicacion = añoPublicacion;
        this.estadoDisponibilidad = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public boolean isEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(boolean estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public boolean estaDisponible(){
        return estadoDisponibilidad;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", a\u00f1oPublicacion=" + añoPublicacion + ", estadoDisponibilidad=" + estadoDisponibilidad + '}';
    }  
    
}
