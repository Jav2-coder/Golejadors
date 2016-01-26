package net.javierjimenez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author alumne1daw
 *
 */
public class Processar extends DefaultHandler {

	/**
	 * Variables String encarregades de contenir el nom
	 * del jugador i del equip quan el programa els llegeis
	 * en el XML.
	 */
	private String nomJugador, equipFutbol = null;

	/**
	 * Variable int encarregada de guardar el total de gols
	 * de cada jugador per equip.
	 */
	private int totalGols = 0;

	/**
	 * Variables boolean encarregades de delimitar un grup
	 * concret d'etiquetes del XML que estem llegint.
	 */
	private boolean jugador, equip, player, team, goal = false;

	/**
	 * HashMap encarregat d'emmagatzemar els equips que
	 * anem creant a l'hora que anem llegint el XML.
	 */
	private HashMap<String, Equip> equips = new HashMap<String, Equip>();

	/**
	 * List que conté tots els objectes Equip.
	 */
	private List<Equip> lliga;

	/**
	 * Metode de final de lectura del document xml on imprimirem
	 * per consola els equips i el seu total de gols ordenats de
	 * major a menor i, dins de cada equip, llistarem els jugadors
	 * i els seu total de gols, ordenats de major a menor.
	 */
	public void endDocument() throws SAXException {
		lliga = new ArrayList<Equip>(equips.values());
		Collections.sort(lliga);	
		for (int i = 0; i < lliga.size(); i++) {
			System.out.println(lliga.get(i).getNomEquip() + ": " + lliga.get(i).totalGols());
			lliga.get(i).llistaJugadors();
			System.out.println();
		}
	}

	/**
	 * Metode de lectura on, segons quina etiqueta s'inicii, capturarem una secció del
	 * XML o una altre.
	 */
	public void startElement(String uri, String localName, String qName, Attributes attr) {
		switch (qName) {
		case "jugador":
			jugador = true;
			break;
		case "equip":
			equip = true;
			break;
		case "nom":
			if (jugador && !equip) {
				player = true;
			} else if (jugador && equip) {
				team = true;
			}
			break;
		case "gols":
			if (jugador && equip) {
				goal = true;
			}
			break;
		}
	}

	/**
	 * Metode de lectura dels valors de cada etiqueta on, segons les
	 * etiquetes que estiguem llegint emmagatzemara el nom del jugador,
	 * el seu total de gols per equip o el nom de l'equip de futbol.
	 */
	public void characters(char[] ch, int start, int length) {
		if (player) {
			nomJugador = new String(ch, start, length);
		}
		if (team) {
			equipFutbol = new String(ch, start, length);
		}
		if (goal) {
			totalGols = Integer.parseInt(new String(ch, start, length));
		}
	}

	public void endElement(String uri, String localName, String qName) {

		switch (qName) {
		case "nom":
			if (jugador && equip) {
				team = false;
			} else if (jugador && !equip) {
				player = false;
			}
		case "gols":
			goal = false;
			break;
		case "equips":
			jugador = false;
			break;
		case "equip":
			if (jugador && equip) {

				if (equips.containsKey(equipFutbol)) {

					equips.get(equipFutbol).addJugador(new Jugador(nomJugador, totalGols));

				} else {

					Equip e = new Equip(equipFutbol);

					e.addJugador(new Jugador(nomJugador, totalGols));

					equips.put(equipFutbol, e);
					
				}
			}
			equip = false;
			break;
		}
	}
}
