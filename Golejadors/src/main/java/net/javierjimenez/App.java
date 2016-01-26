package net.javierjimenez;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 
 * @author alumne1daw
 *
 */
public class App {

	/**
	 * Variable String que conte el directori i el nom del fitxer XML
	 */
	private static String FITXER = "/golejadors.xml";

	/**
	 * Metode principal que llegeix la informacio de l'arxiu xml mitjançant un
	 * parser.
	 * 
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();

		SAXParser parser = spf.newSAXParser();

		InputStream File = App.class.getResourceAsStream(FITXER);

		parser.parse(File, new Processar());

	}
}
