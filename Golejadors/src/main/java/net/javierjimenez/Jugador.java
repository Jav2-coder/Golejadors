package net.javierjimenez;

public class Jugador  implements Comparable<Jugador> {

	private String nom;
	private int gols;

	public Jugador(String n, int g) {

		nom = n;
		gols = g;

	}

	public String getNom() {
		return nom;
	}

	public int getGols() {
		return gols;
	}

	public int compareTo(Jugador j) {

		if (gols > j.getGols()) {

			return -1;

		} else if (gols < j.getGols()) {

			return 1;
		}

		return 0;
	}
}
