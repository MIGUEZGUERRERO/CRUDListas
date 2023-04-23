package pooCRUDListas;

import java.util.ArrayList;
import java.util.Scanner;

public class listapelicula {

	private ArrayList<objetopelicula> hollywood;

	public listapelicula() {
		this.hollywood = new ArrayList<objetopelicula>();

	}

	public void anadirPelicula() {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese el título de la película: ");
		String titulo = entrada.nextLine();
		// Verifica si la película ya existe en la lista
		for(objetopelicula pelicula : hollywood) {
			if(pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("La película ya existe en la lista.");
				return;
			}
		}
		System.out.print("Ingrese el género de la película: ");
		String genero = entrada.nextLine();
		System.out.print("Ingrese el año de la película: ");
		int anio = entrada.nextInt();
		objetopelicula nuevapelicula = new objetopelicula(titulo, genero, anio);
		hollywood.add(nuevapelicula);
		System.out.println("La película ha sido añadida exitosamente.");

		System.out.println("La lista hollywood contiene actualmente " + hollywood.size() + " película/s.");
	}

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

	public void mostrarPeliculas() {
		System.out.println("Listado de películas:");
		for (objetopelicula pelicula : hollywood) {
			System.out.println("Título: " + pelicula.getTitulo());
			System.out.println("Género: " + pelicula.getGenero());
			System.out.println("Año: " + pelicula.getAno());
		

			
		}
		System.out.println("La lista hollywood contiene " + hollywood.size()+ " pelicula/s actualmente.");
	}

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
