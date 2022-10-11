package org.hbrs.s1.ws22.uebung1.control.factory;

import org.hbrs.s1.ws22.uebung1.control.GermanTranslator;

/**
 * Verwendung des Factory Method Design Pattern (GoF)
 * Problem: Inkonsistente Objekterzeugung an potentiell n verschiedenen Stellen
 * Lösung: Breitstellung einer zentralen Klasse zur konsistenten Objekterzeugung
 * und -Parametrisierung
 */

public class TranslatorFactory {

    public static GermanTranslator createGermanTranslator(){
        //Das datum setzen ...
        return new GermanTranslator();
    }
}
