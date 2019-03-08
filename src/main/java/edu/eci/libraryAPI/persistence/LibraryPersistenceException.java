package edu.eci.libraryAPI.persistence;

import org.springframework.http.HttpStatus;

public class LibraryPersistenceException extends Exception{

	private static final long serialVersionUID = 1L;

	public LibraryPersistenceException(String message) {
        super(message);
    }

    public LibraryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

	public LibraryPersistenceException(HttpStatus notFound) {
		
	} 
    
}