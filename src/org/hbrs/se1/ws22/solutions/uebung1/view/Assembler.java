package org.hbrs.se1.ws22.solutions.uebung1.view;

import org.hbrs.se1.ws22.solutions.uebung1.control.EnglishTranslator;
import org.hbrs.se1.ws22.solutions.uebung1.control.GermanTranslator;

public class Assembler {

    public Assembler() {
        GermanTranslator germanTranslator = new GermanTranslator();
        Client client = new Client( germanTranslator );

        client.display(1);

        client.setTranslator( new EnglishTranslator());

        client.display(2);
    }

    public static void main(String[] args) {
        Assembler assembler = new Assembler();
    }

}
