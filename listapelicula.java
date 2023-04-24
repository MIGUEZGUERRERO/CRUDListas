package pooCRUDListas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que recoge una LISTA del objeto pelicula, compuesta por título, género
 * y año de estreno.
 * 
 * @author Francisco Miguez
 * @version 1.4
 */
public class listapelicula {
	/**
	 * Lista de películas almacenadas con nombre hollywood.
	 */

	private ArrayList<objetopelicula> hollywood;

	/**
	 * Constructor que inicializa la lista de películas.
	 */

	public listapelicula() {
		this.hollywood = new ArrayList<objetopelicula>();

	}

	/**
	 * Método para añadir una película a una lista.
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void anadirPelicula() {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese el título de la película: ");
		String titulo = entrada.nextLine();
		// Verifica si la película ya existe en la lista
		for (objetopelicula pelicula : hollywood) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("La película ya existe en la lista.");
				return;
			}
		}
		System.out.print("Ingrese el género de la película: ");
		String genero = entrada.nextLine();
		System.out.print("Ingrese el año de la película: ");
		int ano = entrada.nextInt();
		objetopelicula nuevapelicula = new objetopelicula(titulo,genero,ano);
		hollywood.add(nuevapelicula);
		System.out.println("La película ha sido añadida exitosamente.");

		System.out.println("La lista hollywood contiene actualmente " + hollywood.size() + " película/s.");
	}

	/**
	 * Método para modificar datos de una película existente en una lista.
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void modificarPelicula() {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese el título de la película a modificar: ");
		String tituloPelicula = entrada.nextLine();
		int indicePelicula = -1;
		objetopelicula peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada == null) {
			System.out.println("La película no se encuentra en la lista. No se puede modificar.");
			return;
		}
		if (peliculaEncontrada != null) {

			objetopelicula peliculaModificada = new objetopelicula(tituloPelicula, tituloPelicula, 0);

			System.out.println("Introduce el nuevo título de la película:");
			peliculaModificada.setTitulo(entrada.nextLine());
			System.out.println("Introduce el nuevo género de la película:");
			peliculaModificada.setGenero(entrada.nextLine());
			System.out.println("Introduce el nuevo año de la película:");
			peliculaModificada.setAno(entrada.nextInt());

			indicePelicula = hollywood.indexOf(peliculaEncontrada);
			hollywood.set(indicePelicula, peliculaModificada);
			System.out.println("La película se ha modificado correctamente.");
		}

	}

	/**
	 * Método para eliminar una película de una lista.
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void borrarPelicula() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese el título de la película a eliminar: ");
		String tituloPelicula = entrada.nextLine();
		objetopelicula peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada != null) {
			hollywood.remove(peliculaEncontrada);
			System.out.println("La película ha sido eliminada correctamente.");
		} else {
			System.out.println("La película no ha sido encontrada en la lista.");
		}
		System.out.println("La lista hollywood contiene ahora " + hollywood.size() + " película/s.");
	}

	/**
	 * Método para buscar película en una lista.
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void buscarPelicula() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el título de la película a buscar: ");
		String tituloPelicula = entrada.nextLine();

		objetopelicula peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada != null) {
			System.out.println("Título: " + peliculaEncontrada.getTitulo());
			System.out.println("Género: " + peliculaEncontrada.getGenero());
			System.out.println("Año: " + peliculaEncontrada.getAno());
		} else {
			System.out.println("La película no se encontró en la lista.");
		}

	}

	/**
	 * Método para mostrar las películas almacenadas en una lista.
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void mostrarPeliculas() {
		System.out.println("Listado de películas:");
		for (objetopelicula pelicula : hollywood) {
			System.out.println("Título: " + pelicula.getTitulo());
			System.out.println("Género: " + pelicula.getGenero());
			System.out.println("Año: " + pelicula.getAno());

		}
		System.out.println("La lista hollywood contiene " + hollywood.size() + " pelicula/s actualmente.");
	}

	
	
	/**
	 * Método que pueden acceder otros métodos para buscar una película en una
	 * lista.
	 * 
	 * @param hollywood      Lista de películas en la que se realizará la búsqueda.
	 * @param tituloPelicula Título de la película a buscar.
	 * @return La película encontrada o null si no se encuentra.
	 */
	private objetopelicula buscadorpeliculas(ArrayList<objetopelicula> hollywood, String tituloPelicula) {
		// TODO Auto-generated method stub
		for (objetopelicula pelicula : hollywood) {
			if (pelicula.getTitulo().equalsIgnoreCase(tituloPelicula)) {
				return pelicula;
			}
		}
		return null;
	}
}
