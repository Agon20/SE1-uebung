
package org.hbrs.se1.ws22.solutions.uebung2.test;

import org.hbrs.se1.ws22.solutions.uebung2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container container = null;

    @BeforeEach
    void setUp() {
        // Den Container anlegen
        container = new Container();
    }

    @Test
    void addAndDeleteMember() {
        // Test-Objekte anlegen
        Member r1 = new MemberKonkret(12);
        Member r2 = new MemberKonkret(32);
        Member r3 = new MemberKonkret(112);
        Member r4 = new MemberKonkret(1211);
        Member r5 = new MemberKonkret(934);

        // Testfall 1 - Check auf leeren Container
        assertEquals(0, container.size(),
                "Testfall 1 - Pruefung auf leeren Store");

        try {
            container.addMember(r1);
            container.addMember(r2);
            container.addMember(r3);
            container.addMember(r4);

        } catch (ContainerException e) {
            e.printStackTrace();
        }


        // Testfall 2 - Pruefen, ob vier Objekte eingefuegt wurden
        assertEquals(4, container.size(), "Testfall 2 - Prüfen, ob vier Objekte eingefuegt wurden");


        try {
            container.addMember(r5);
        } catch (ContainerException e) {
            e.printStackTrace();
        }

        // Testfall 3 - Pruefen, ob fuenftes Objekt eingefuegt wurde
        assertEquals(5, container.size(), "Testfall 3 - Prüfen, ob fuenftes Objekt eingefuegt wurde");

        String result = container.deleteMember(12);
        // System.out.println( result );

        // Testfall 4 - Pruefen, ob Objekt geloescht wurde
        assertEquals(4, container.size(), "Testfall 4 - Prüfen, ob Objekt geloescht wurde");

        result = container.deleteMember(12222);
        System.out.println(result);

        // Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde
        assertEquals(4, container.size(), "Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde");

        try {
            container.addMember(r2);
        } catch (ContainerException e) {

            e.printStackTrace();

        } finally {

            // Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde
            assertEquals(4, container.size(), "Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde");
        }
    }

    @Test
    public void dumpAndSizeAndNull() {
            // Test der Dump-Funktion (ohne Kontrolle)
            container.dump();
            assertEquals(0 , container.size() ) ;

            // Test der Size-Funktion
            container.size();
            assertEquals(0 , container.size() ) ;

            // Test auf NULL - der "altbekannte" Weg
            try {
                container.addMember(null);
            } catch (ContainerException e) {
                assertEquals( "NULL-Werte dürfen nicht aufgenommen werden!" ,
                        e.getMessage() );
            }
            assertEquals(0 , container.size() ) ;

            // Test auf NULL - der "moderne" Weg
            assertThrows( ContainerException.class, () -> { container.addMember(null); } );
            assertEquals(0 , container.size() ) ;
        }


}