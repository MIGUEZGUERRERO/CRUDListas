package pooCRUDListas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.Test;

class listapeliculaTest extends controladorpelicula  {

	 @Test
	 public void testBuscadorPeliculas() {
		    ArrayList<objetopelicula> listaPeliculas = new ArrayList<>();
		    
		    objetopelicula elPadrino = new objetopelicula("Matrix", "C.F.", 1999);
		    listaPeliculas.add(elPadrino);
		  
		    String tituloBuscado = "Matrix";
		    objetopelicula peliculaEncontrada = buscadorpeliculas(listaPeliculas, tituloBuscado);
		    assertEquals("El Padrino", peliculaEncontrada.getTitulo());
		   
		}

		private objetopelicula buscadorpeliculas(ArrayList<objetopelicula> hollywood, String tituloPelicula) {
		    for (objetopelicula pelicula : hollywood) {
		        if (pelicula.getTitulo().equalsIgnoreCase(tituloPelicula)) {
		            return pelicula;
		        }
		    }
		    return null;
		}
		

		@Test
		public void testAnadirPelicula() {
		        ArrayList<objetopelicula> listaPeliculas = new ArrayList<>();
		        Scanner entrada = new Scanner("\"Matrix\", \"C.F.\", 1999");
		        anadirPelicula(listaPeliculas, entrada);
		        assertEquals(1, listaPeliculas.size());
		        assertEquals("Matrix", listaPeliculas.get(0).getTitulo());
		        assertEquals("C.F.", listaPeliculas.get(0).getGenero());
		        assertEquals(1999, listaPeliculas.get(0).getAno());
		    }

		    private void anadirPelicula(ArrayList<objetopelicula> hollywood, Scanner entrada) {
		        String titulo = entrada.nextLine();
		        for (objetopelicula pelicula : hollywood) {
		            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
		                return;
		            }
		        }
		        String genero = entrada.nextLine();
		        int ano = entrada.nextInt();
		        entrada.nextLine(); 
		        objetopelicula nuevapelicula = new objetopelicula(titulo, genero, ano);
		        hollywood.add(nuevapelicula);
		    }

		
	@Test
	public void testBorrarPelicula() {
	    ArrayList<objetopelicula> hollywood = new ArrayList<>();
	    
	    String tituloPeliculaAEliminar = "Matrix";
	    borrarPelicula(hollywood, tituloPeliculaAEliminar);

	    objetopelicula peliculaEncontrada = buscadorpeliculas(hollywood, tituloPeliculaAEliminar);
	    assertNull(peliculaEncontrada);
	}

	private void borrarPelicula(ArrayList<objetopelicula> hollywood, String tituloPelicula) {
	    objetopelicula peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

	    if (peliculaEncontrada != null) {
	        hollywood.remove(peliculaEncontrada);
	        System.out.println("La película ha sido eliminada correctamente.");
	    } else {
	        System.out.println("La película no ha sido encontrada en la lista.");
	    }
	    System.out.println("La lista hollywood contiene ahora " + hollywood.size() + " película/s.");
	}

	
	 
	@Test
	public void testMostrarPeliculas2() {
        listapelicula peliculas = new listapelicula();

        objetopelicula pelicula1 = new objetopelicula("Matrix", "C.F.", 1999);
        objetopelicula pelicula2 = new objetopelicula("Matrix Reloaded", "C.F", 2003);
        objetopelicula pelicula3 = new objetopelicula("Matrix Revolutions", "C.F.", 2003);
        ArrayList<objetopelicula> hollywood = new ArrayList<>();
      
        
        hollywood.add(pelicula1);
        hollywood.add(pelicula2);
        hollywood.add(pelicula3);

        ByteArrayOutputStream salidaEsperada = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(salidaEsperada);
        ps.println("Listado de películas:");
        ps.println("Título: Matrix");
        ps.println("Género: C.F.");
        ps.println("Año: 1999");
        ps.println("Título: Matrix Reloaded");
        ps.println("Género: C.F.");
        ps.println("Año: 2003");
        ps.println("Título: Matrix Revolutions");
        ps.println("Género: C.F.");
        ps.println("Año: 2003");
        ps.println("La lista hollywood contiene 3 pelicula/s actualmente.");
        ps.close();

        ByteArrayOutputStream salidaReal = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaReal));
        peliculas.mostrarPeliculas();
        System.setOut(System.out);

        String resultadoEsperado = salidaEsperada.toString();
        String resultadoReal = salidaReal.toString();

        assertEquals(resultadoEsperado, resultadoReal);
    }
}
