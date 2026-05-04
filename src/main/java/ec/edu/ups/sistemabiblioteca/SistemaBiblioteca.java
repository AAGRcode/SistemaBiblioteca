package ec.edu.ups.sistemabiblioteca;

import ec.edu.ups.sistemabiblioteca.clases.Autor;
import ec.edu.ups.sistemabiblioteca.clases.Libro;
import ec.edu.ups.sistemabiblioteca.clases.Persona;
import ec.edu.ups.sistemabiblioteca.clases.PrestamoLibro;
import ec.edu.ups.sistemabiblioteca.clases.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AAGR
 */
public class SistemaBiblioteca {
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<PrestamoLibro> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);    
    
    public static void main(String[] args){
        cargarDatos();
        
        int opcion=0;
        while(opcion!=3){
            System.out.println("SISTEMA DE PRESTAMO DE LIBROS");
            System.out.println("");
            System.out.println("1. Bibliotecario");
            System.out.println("2. Usuario");
            System.out.println("3. Volver");
            System.out.println("Ingrese la ocpion: ");
            opcion=sc.nextInt();
            
            switch(opcion){
                case 1:
                    menuBibliotecario();
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 3:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                   

            }
        }
    }
    public static void menuBibliotecario(){
        int opcion=0;
        while(opcion!=4){
            System.out.println("MENU BIBLIOTECARIO");
            System.out.println("1. Registrar usario");
            System.out.println("2. Registrar libro");
            System.out.println("3. Ver todos libros");
            System.out.println("4. Volver");
            System.out.println("Ingrese la ocpion: ");
            opcion=sc.nextInt();
            
            if(opcion==1){
                registrarUsuario();
            }else if(opcion==2){
                registrarLibro();
            }else if(opcion==3){
                verLibros();
            }else if(opcion==4){
                System.out.println("Regresando");
            }else{
                System.out.println("OPCION INCORRECTA");
            }
            
        }
    }
    
    public static void menuUsuario(){
        Usuario usuario = autenticar();
        if(usuario==null){
            return;
        }
        int opcion=0;
        while(opcion!=3){
            System.out.println("\nUSUARIO"+usuario.getDatosUsuario().getNombreCompleto());
            System.out.println("MENU USUARIO");
            System.out.println("1. Pedir libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Salir");
            System.out.println("Ingrese la opcion: ");
            opcion=sc.nextInt();
            if(opcion==1){
                pedirPrestamo(usuario);
            }
        }
    }
    
    public static void registrarUsuario(){
        sc.nextLine();
        System.out.println("\nRegistrar Usuario");
        System.out.println("Nombre Completo: ");
        String nombre = sc.nextLine();
        System.out.println("Cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Clave: ");
        String clave = sc.nextLine();
        
        Persona persona = new Persona(nombre, edad, cedula);
        usuarios.add(new Usuario(persona, clave));
        System.out.println("Usuario registrado");
    }
    
    public static void registrarLibro(){
        sc.nextLine();
        System.out.println("\nRegistrar Libro");
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        System.out.println("Categoria: ");
        String categoria = sc.nextLine();
        System.out.println("Autor: ");
        String nombreAutor = sc.nextLine(); 
        System.out.println("Nacionalidad: ");
        String nac = sc.nextLine();
        System.out.println("Año de Publicacion: ");
        int año= sc.nextInt();
        System.out.println("Año de Nacimiento de Autor: ");
        int añoAutor = sc.nextInt();
        
        Autor autor = new Autor(nombreAutor, nac, añoAutor);
        libros.add(new Libro(libros.size()+1, titulo, categoria, año, autor));
        System.out.println("Libro Registrado");
    }
    
    public static void verLibros(){
        System.out.println("\nLibros:");
        if(libros.isEmpty()){
            System.out.println("No hay libros");
            return;
        }
        for(Libro l : libros){
            System.out.println(" " + l);
        }
    }
    
    public static void pedirPrestamo(Usuario usuario){
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        boolean hay = false;
        for (Libro l : libros) {
            if (l.estaDisponible()) {
                System.out.println("  " + l);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("  No hay libros disponibles en este momento.");
            return;
        }
 
        System.out.print("\n  Ingrese el ID del libro: ");
        int id = sc.nextInt();
 
        Libro libro = null;
        for(Libro l :libros){
            if(l.getId()==id){
                libro=l;
                break;
            }
        }
        if (libro == null) {
            System.out.println("  No se encontro un libro con ese ID.");
            return;
        }
 
        System.out.println("\n  Fecha limite de devolucion:");
        System.out.print("  Anio : "); int añoD = sc.nextInt();
        System.out.print("  Mes  : "); int mesD  = sc.nextInt();
        System.out.print("  Dia  : "); int diaD  = sc.nextInt();
        
        PrestamoLibro prestamo = usuario.pedirLibro(libro);
        if(prestamo!=null){
            prestamo.setFechaDevolucion(new Date(añoD-1900, mesD-1, diaD));
            System.out.println("Prestamo #" + prestamo.getId() + " registrado.");
            System.out.println("Libro   : " + libro.getTitulo());
            System.out.println("Usuario : " + usuario.getDatosUsuario().getNombreCompleto());
            System.out.println("Entrega : " + prestamo.getFechaDevolucion());
        } 
    }
    
    public static Usuario autenticar(){
        sc.nextLine();
        System.out.println("\nIngrese la cedula");
        String cedula = sc.next();
        System.out.println("\nIngrese la clave");
        String clave = sc.next();
        
        for(Usuario u : usuarios){
            if (u.getDatosUsuario().getCedula().equals(cedula) && u.getClave().equals(clave)) {
                System.out.println("Bienvenido/a, " + u.getDatosUsuario().getNombreCompleto());
                return u;
            }
        }             
        System.out.println("Cedula o clave incorrecta.");
        return null;
    }
    
    public static void cargarDatos() {
        Autor a1 = new Autor("Gabriel Garcia Marquez", "Colombiana", 1927);
        Autor a2 = new Autor("George Orwell", "Britanica", 1903);
        libros.add(new Libro(1, "Cien Anos de Soledad", "Novela",   1967, a1));
        libros.add(new Libro(2, "1984",                 "Distopia", 1949, a2));
 
        Persona p1 = new Persona("Juan Perez", 25, "123456789");
        usuarios.add(new Usuario(p1, "1234"));
}
}