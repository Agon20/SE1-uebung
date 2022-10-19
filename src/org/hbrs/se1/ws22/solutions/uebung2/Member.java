package org.hbrs.se1.ws22.solutions.uebung2;

public interface Member {
	
	// ID ist in einem abgeleiteten Objekt über eine Konstruktor-Methode zu belegen 
	// --> Primaerschluessel zur Unterscheidung aller Member-Objekte
	Integer getID();
	
	public String toString();

}
 