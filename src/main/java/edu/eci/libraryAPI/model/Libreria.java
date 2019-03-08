package edu.eci.libraryAPI.model;

import java.util.List;

public class Libreria {
	
    private String nombre;
    private int id;
    private String direccion;
    private String telefono;
    private List<Libro> libros;
    
    
    public Libreria(){
		
	}
    
    public Libreria(String nombre, int id, String direccion, String telefono, List<Libro> libros) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.direccion = direccion;
		this.telefono = telefono;
		this.libros = libros;
	}
	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	
	
    
    
}