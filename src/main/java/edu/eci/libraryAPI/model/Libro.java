package edu.eci.libraryAPI.model;

public class Libro {
	
    private String nombre;
    private int id;
    private String autor;
    private String sinopsis;
    
    public Libro() {
		
	}
	    
	public Libro(String nombre, int id, String autor, String sinopsis) {
		this.nombre = nombre;
		this.id = id;
		this.autor = autor;
		this.sinopsis = sinopsis;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
    
    
}