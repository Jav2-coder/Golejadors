package net.javierjimenez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equip implements Comparable<Equip> {

	private String nom;
	private List<Jugador> jugadors = new ArrayList<Jugador>();
	
	public Equip(String n) {
		
		nom = n;
		
	}
	
	public void addJugador(Jugador j){
		
		jugadors.add(j);
		
	}

	public String getNomEquip() {
		
		return nom;
		
	}
	
	public int totalGols(){
		
		int gols = 0;
		
		for (int i = 0; i < jugadors.size(); i++){
			
			gols = gols + jugadors.get(i).getGols();
			
		}
		
		return gols;
		
	}
	
	public void llistaJugadors() {
		
		Collections.sort(jugadors);
		
		for (int i = 0; i < jugadors.size(); i++){
			
			System.out.println("	" + jugadors.get(i).getNom() + ": " + jugadors.get(i).getGols());
			
		}
	}
	
	public int compareTo(Equip e) {

		if (totalGols() > e.totalGols()) {

			return -1;

		} else if (totalGols() < e.totalGols()) {

			return 1;
		}

		return 0;
	}
	
}
