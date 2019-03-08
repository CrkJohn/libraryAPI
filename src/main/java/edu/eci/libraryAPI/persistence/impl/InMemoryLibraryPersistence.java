package edu.eci.libraryAPI.persistence.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import edu.eci.libraryAPI.controllers.ResourceNotFoundException;
import edu.eci.libraryAPI.model.Libreria;
import edu.eci.libraryAPI.model.Libro;
import edu.eci.libraryAPI.model.MyEmailer;
import edu.eci.libraryAPI.persistence.LibraryPersistenceException;
import edu.eci.libraryAPI.persistence.LibraryPersitence;

@Component("InMemoryLibraryPersistence")
public class InMemoryLibraryPersistence implements LibraryPersitence {

	private final Map<Integer, Libreria> librerias = new HashMap<>();
	private static String categories[] = { "Drama", "Terror", "Suspenso" };
	private static String names[] = { "Garavito", "Cordova", "OtraAhi" };
	private static String Direccion[] = { "Dg 178 cbis 15 a 12", "Dg 118 cbis 25 a 12", "Dg 178 cbis 15 a 13" };
	private static String Telefono[] = { "12345", "1267", "12765" };

	public InMemoryLibraryPersistence() {
		List<Libro> libros;
		Libro libro;

		Random random = new Random();
		for (int j = 0; j < 3; j++) {
			libros = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				String nombre = "LibroARSW " + i;
				int id = i;
				String autor = "AutorARSW" + i;
				int ind = random.nextInt(categories.length);
				String sinopsis = "Una historia que trata de " + categories[ind];
				libro = new Libro(nombre, id, autor, sinopsis);
				libros.add(libro);
			}
			librerias.put(j, new Libreria(names[j], j, Direccion[j], Telefono[j], libros));
		}
		librerias.put(4, new Libreria(names[1], 4, Direccion[1], Telefono[1], new ArrayList<>()));

	}

	@Override
	public Set<Libreria> getAllLibreria() {
		Set<Libreria> lb = new HashSet<Libreria>();
		for (Map.Entry<Integer, Libreria> e : librerias.entrySet()) {
			lb.add(e.getValue());
		}
		return lb;
	}

	@Override
	public List<Libro> getAllLibros(int libreria) throws LibraryPersistenceException {
		List<Libro> books = null;
		for (Map.Entry<Integer, Libreria> e : librerias.entrySet()) {
			if (e.getKey() == libreria) {
				return e.getValue().getLibros();
			}
		}
		throw new LibraryPersistenceException("The library dont exits");

	}

	@Override
	public void deleteLibrary(int id) throws LibraryPersistenceException {
		if (librerias.containsKey(id)) {
			if (librerias.get(id).getLibros().size() != 0) {
				throw new LibraryPersistenceException("forbidden");
			} else {
				librerias.remove(id);
			}
		} else {
			throw new LibraryPersistenceException("NOT FOUND");
		}
	}

	@Override
	public void createHilo(int id, Libro bk) {
		ThreadJohn threadJohn = new ThreadJohn(id, bk);
		threadJohn.start();
	}

	private class ThreadJohn extends Thread {

		private int id;
		private Libro bk;
		private MyEmailer  email;
		public ThreadJohn(int id, Libro bk) {
			this.id = id;
			this.bk = bk;
			email = new MyEmailer();
			
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				email.sendMessage();
				if (librerias.containsKey(id)) {
					librerias.get(id).getLibros().add(bk);
				} else {
					List<Libro> libros = new ArrayList<>();
					libros.add(bk);
					librerias.put(id, new Libreria(names[0], id, Direccion[1], Telefono[2], libros));
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

	}

}
