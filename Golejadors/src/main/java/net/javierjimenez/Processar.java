package net.javierjimenez;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {

	private String nomJugador, equipFutbol = null;

	private int totalGols = 0;

	private boolean jugador, equip, player, team, goal = false;

	private HashMap<String, Equip> equips = new HashMap<String, Equip>();

	private List<Equip> lliga;

	public void endDocument() throws SAXException {

		lliga = new ArrayList<Equip>(equips.values());

		Collections.sort(lliga);
		
		for (int i = 0; i < lliga.size(); i++) {
			System.out.println(lliga.get(i).getNomEquip() + ": " + lliga.get(i).totalGols());
			lliga.get(i).llistaJugadors();
			System.out.println();
		}

	}

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
