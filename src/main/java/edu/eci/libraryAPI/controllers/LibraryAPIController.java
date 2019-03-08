package edu.eci.libraryAPI.controllers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.libraryAPI.LibraryAPIApplication;
import edu.eci.libraryAPI.model.Libro;
import edu.eci.libraryAPI.services.LibraryServices;


@RestController
public class LibraryAPIController {

	@Autowired
	LibraryServices libraryServices;

	@GetMapping("/libraries")
	public ResponseEntity<?> getAllLibraries(){
		try {
			return new ResponseEntity<>(libraryServices.getAllLibreries() ,  HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error, no cinemas were found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("libraries/{id}")
	public ResponseEntity<?> getAllLibros(@PathVariable  int id){
		try {
			return new ResponseEntity<>(libraryServices.getAllLibros(id) ,  HttpStatus.ACCEPTED);
		} catch (Exception ex){
			return new ResponseEntity<>("Error, dont not  were found", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("libraries/{id}")
	public ResponseEntity<?> deleteLibrary(@PathVariable  int id){
		try {
			libraryServices.deleteLibrary(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception ex){
			if(ex.getMessage().equals("forbidden")) {
				return new ResponseEntity<>(" FORBIDDEN", HttpStatus.FORBIDDEN);
			}else {
				return new ResponseEntity<>(" NOT_FOUND", HttpStatus.NOT_FOUND);
			}
			
		}
	}
	
	/*
	 * 
curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/libraries/0/jhonhrge@gmail.com -d '{"nombre":"LibroPruebaPostARSW0","id":0,"autor":"AutorARSW0","sinopsis":"Una historia que trata de Drama"}'
	 */
	
	@PostMapping("libraries/{id}/{correo}")
	public ResponseEntity<?> addBooks(@PathVariable  int id ,@PathVariable String correo,  @RequestBody Libro bk){
		try {
			libraryServices.createHilo(id,bk,correo);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception ex){
			if(ex.getMessage().equals("forbidden")) {
				return new ResponseEntity<>(" FORBIDDEN", HttpStatus.FORBIDDEN);
			}else {
				return new ResponseEntity<>(" NOT_FOUND", HttpStatus.NOT_FOUND);
			}
			
		}
	}
}