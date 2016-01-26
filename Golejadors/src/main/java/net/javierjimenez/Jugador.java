package net.javierjimenez;

/**
 * 
 * @author alumne1daw
 *
 */
public class Jugador implements Comparable<Jugador> {

	/**
	 * Variable String que conte el nom de l'objecte Jugador
	 */
	private String nom;
	
	/**
	 * Variable int que conte el total de gols de l'objecte Jugador
	 */
	private int gols;

	/**
	 * Constructor principal de l'objecte Jugador
	 * 
	 * @param n Variable String que conte el nom del Jugador
	 * @param g Variable int que conte el total de gols del Jugador
	 */
	public Jugador(String n, int g) {
		nom = n;
		gols = g;
	}

	/**
	 * Metode que retorna el nom del Jugador
	 * 
	 * @return Variable String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Metode que retorna el total de gols del Jugador
	 * 
	 * @return Variable int
	 */
	public int getGols() {
		return gols;
	}

	/**
	 * Metode per ordenar la llista de Jugadors per total
	 * de gols, de major a menor
	 */
	public int compareTo(Jugador j) {

		if (gols > j.getGols()) {

			return -1;

		} else if (gols < j.getGols()) {

			return 1;
		}

		return 0;
	}
}
