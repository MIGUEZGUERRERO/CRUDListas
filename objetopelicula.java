package pooCRUDListas;

/**
 * Clase que recoge el OBJETO pelicula, compuesta por título, género y año de
 * estreno.
 * 
 * @author Francisco Miguez
 * @version 1.3
 */
public class objetopelicula {

	// Atributos de la pelicula.
	private String titulo;
	private String genero;
	private int ano;

	/**
	 * Constructor de la clase "objetopelicula".
	 * 
	 * @param titulo El título de la película.
	 * @param genero El género de la película.
	 * @param ano    El año de estreno de la película.
	 */
	public objetopelicula(String titulo, String genero, int ano) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.ano = ano;
	}

	/**
	 * Método getter. Devuelve el título de la película.
	 * 
	 * @return El título de la película.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método setter. Establece título de la película.
	 * 
	 * @param titulo El título de la película.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Método getter.Devuelve el género de la película.
	 * 
	 * @return El género de la película.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Método setter.Establece el género de la película.
	 * 
	 * @param genero El género de la película.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Método getter.Devuelve el año de estreno de la película.
	 * 
	 * @return El año de estreno de la película.
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Método setter.Establece el año de estreno de la película.
	 * 
	 * @param ano El año de estreno de la película.
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Devuelve una cadena de caracteres del objeto película.
	 * 
	 * @return Una cadena de caracteres del objeto película.
	 */
	@Override
	public String toString() {
		return "objetopelicula [titulo=" + titulo + ", genero=" + genero + ", ano=" + ano + "]";
	}

}
