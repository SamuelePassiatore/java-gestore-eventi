package org.java.obj;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		try {
			Evento concert = new Evento("Concerto", LocalDate.of(2023, 5, 30), 100);
			System.out.println("Evento: " + concert.toString());

			concert.setNumberPlacesTotal(200);
			System.out.println("Numero posti totali: " + concert.getNumberPlacesTotal());

			concert.setNumberPlacesTotal(50); 
		} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}
}
