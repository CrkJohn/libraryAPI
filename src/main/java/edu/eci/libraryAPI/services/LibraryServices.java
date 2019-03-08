package edu.eci.libraryAPI.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.libraryAPI.model.Libreria;
import edu.eci.libraryAPI.model.Libro;
import edu.eci.libraryAPI.persistence.LibraryPersistenceException;
import edu.eci.libraryAPI.persistence.LibraryPersitence;

@Service
public class LibraryServices {
	
	 @Autowired
	 @Qualifier("InMemoryLibraryPersistence")
	 LibraryPersitence libraryPersistence;
		 
	 
	 public Set<Libreria> getAllLibreries(){
		 return libraryPersistence.getAllLibreria();
	 }
	 
	 

	public List<Libro> getAllLibros(int libreria) throws LibraryPersistenceException{
		return libraryPersistence.getAllLibros(libreria);
	}



	public void deleteLibrary(int id) throws LibraryPersistenceException {
		libraryPersistence.deleteLibrary(id);
	}



	public void createHilo(int id, Libro bk, String correo) throws LibraryPersistenceException  {
		libraryPersistence.createHilo(id,bk,correo);
	}
	 
	 
	 
	
	
	
}
