package pooCRUDListas;

import java.util.Scanner;

/**
 * Clase que contiene metodo principal para ejecutar el programa.
 * 
 * @author Francisco Miguez.
 * @version 1.6
 */
public class controladorpelicula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		listapelicula peliculas = new listapelicula();
		int opción = 0;
		do {
			// Mestra el menú al usuario.
			System.out.println("********** MENU LA CLAQUETA **********");
			System.out.println("1. Añadir película");
			System.out.println("2. Modificar película");
			System.out.println("3. Borrar película");
			System.out.println("4. Buscar película por título");
			System.out.println("5. Mostrar coleción");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción del MENU: ");
			// Recoge la opción del usuario.
			opción = entrada.nextInt();
			entrada.nextLine();
			// Se utiliza condicional switch para ejecutar la opción correspondiente.
			switch (opción) {
			case 1:
				try {
					peliculas.anadirPelicula();
				} catch (java.util.InputMismatchException ex ) {
					System.out.println("ERROR");
				} catch (Exception e) {
					System.out.println("ERROR");
				}
				break;
			case 2:
				peliculas.modificarPelicula();
				break;
			case 3:
				peliculas.borrarPelicula();
				break;
			case 4:
				peliculas.buscarPelicula();
				break;
			case 5:
				peliculas.mostrarPeliculas();
				break;
			case 6:
				// Gestiona la opción de salir del programa.
				System.out.println("Sayonara Baby");
				break;

			default:
				// Si no está recogido dentro de las opciones del menú, pide al usuario que
				// elija una de las opciones.
				System.out.println("Por favor, elija una opción del MENU");
				break;

			}

		} while (opción != 6);
		// Cierra Scanner
		entrada.close();
	}

}
