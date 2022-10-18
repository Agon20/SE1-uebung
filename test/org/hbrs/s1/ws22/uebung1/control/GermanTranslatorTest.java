package org.hbrs.s1.ws22.uebung1.control;
import org.junit.*;
import static org.junit.Assert.*;


public class GermanTranslatorTest {

    @Test
    public void testTranslateNumber() {
        //given
        var GermanTranslator = new GermanTranslator();
        int input1 = -21;
        int input2 = 5;
        int input3 = 121;

        //@BeforeEach -> new GermanTranslator()
        // startet jedes mal vor der Testmethode
        //nutze danach @AfterEach, @BeforAll, @AfterAll

        //probier mal mit void ... Exception thrown = assertThrows...
        // assertEquals

        //Schau dir was void init(); ist


        //test 1
        System.out.println("Testvorgang: 1 startet...");
        assertEquals("Huch, what happened her... :o",GermanTranslator.translateNumber(input1),
                "Übersetzung der Zahl " + input1 + " nicht möglich" + "[" + GermanTranslator.versionTest + "]");
        System.out.println("...endlich fertig.");

        //test 2
        System.out.println("Testvorgang: 2 startet...");
        assertEquals("Huch, what happened her... :o",GermanTranslator.translateNumber(input2),
                "fünf");
        System.out.println("...endlich fertig.");

        //test 3
        System.out.println("Testvorgang: 3 startet...");
        assertEquals("Huch, what happened her... :o",GermanTranslator.translateNumber(input3),
                "Übersetzung der Zahl " + input3 + " nicht möglich" + "[" + GermanTranslator.versionTest + "]");
        System.out.println("...endlich fertig.");
    }
}