package org.hbrs.s1.ws22.uebung1.view;

import org.hbrs.s1.ws22.uebung1.control.GermanTranslator;
import org.hbrs.s1.ws22.uebung1.control.Translator;
import org.hbrs.s1.ws22.uebung1.control.factory.TranslatorFactory;

/*
 * @author aazemi2s
 */
public class Client implements Translator {

		/*
		 * Methode zur Ausgabe einer Zahl auf der Console (auch bezeichnet als CLI, Terminal)
		 */
		public void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung gegen das Interface Translator gewuenscht!

			//Statt GermanTranslator kann man hier auch translator schreiben,
			// um bei nutzen eines anderen Translator, zbs. Englisch,
			// ohne Benennungs-Problem ändern kann (Dedekation(?))

			//schau mal wie du anders die Referenz aus den translator hinkriegen kannst
			// was macht ein Assembler? (Dependency Injection bzw DI)
			// psvm enter
			//mit extends under das Interface, alles nicht mehr nötig, direkt nutzen no reference (quick and dirty)
			//Implementierungsvererbung nennt man das



			GermanTranslator translator = TranslatorFactory.createGermanTranslator();
			String result = translator.translateNumber(1);

			System.out.println("Das Ergebnis der Berechnung: " +
					"[das Ergebnis an dieser Stelle]" + result);

		}
	public String translateNumber( int number ) {
		return null;
	}
}





