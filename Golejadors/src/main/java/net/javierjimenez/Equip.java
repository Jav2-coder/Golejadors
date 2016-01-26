package net.javierjimenez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author alumne1daw
 *
 */
public class Equip implements Comparable<Equip> {

	/**
	 * Variable String que conte el nom de l'objecte Equip
	 */
	private String nom;
	
	/**
	 * List que conte tots els objectes Jugador per aquest Equip
	 */
	private List<Jugador> jugadors = new ArrayList<Jugador>();
	
	/**
	 * Constructor principal de l'objecte Equip
	 * 
	 * @param n Variable String que conte el nom de l'Equip
	 */
	public Equip(String n) {	
		nom = n;
	}
	
	/**
	 * Metode per afegir un nou jugador a l'objecte Equip
	 * 
	 * @param j Objecte Jugador que afegirem.
	 */
	public void addJugador(Jugador j){	
		jugadors.add(j);	
	}

	/**
	 * Metode que ens retorna el nom de l'Equip
	 * 
	 * @return Variable String
	 */
	public String getNomEquip() {
		return nom;
	}
	
	/**
	 * Metode encarregat de sumar i retornar els gols de cada jugador
	 * per aixi obtenir el total de gols per Equip
	 * 
	 * @return Variable int
	 */
	public int totalGols(){
		int gols = 0;
		for (int i = 0; i < jugadors.size(); i++){	
			gols = gols + jugadors.get(i).getGols();
		}
		return gols;
	}
	
	/**
	 * Metode encarregat de llistar per consola els jugadors
	 * de cada equip, ordenats per total de gols (de major a
	 * menor).
	 */
	public void llistaJugadors() {
		Collections.sort(jugadors);
		for (int i = 0; i < jugadors.size(); i++){	
			System.out.println("	" + jugadors.get(i).getNom() + ": " + jugadors.get(i).getGols());	
		}
	}
	
	/**
	 * Metode encarregat de comparar els Equips per tal de poder
	 * ordenarlos de major total de gols a menor.
	 */
	public int compareTo(Equip e) {
		if (totalGols() > e.totalGols()) {
			return -1;
		} else if (totalGols() < e.totalGols()) {
			return 1;
		}
		return 0;
	}	
}
