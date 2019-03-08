package edu.eci.libraryAPI.persistence;

import java.util.Set;
import java.util.List;


import edu.eci.libraryAPI.model.*;

public interface LibraryPersitence {
	
	
	public Set<Libreria> getAllLibreria();
	public List<Libro> getAllLibros(int libreria) throws LibraryPersistenceException;
	public void deleteLibrary(int id) throws LibraryPersistenceException;
	public void createHilo(int id, Libro bk, String correo);
	
	
}
