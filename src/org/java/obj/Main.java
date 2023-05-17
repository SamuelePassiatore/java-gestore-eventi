package org.java.obj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Concerto concerto1 = new Concerto("Bob Marley", LocalDate.of(2023, 7, 27), 2000, LocalTime.of(21, 30), new BigDecimal("80.99"));
		Concerto concerto2 = new Concerto("Lady Gaga", LocalDate.of(2023, 8, 27), 2000, LocalTime.of(22, 30), new BigDecimal("60.50"));
		Concerto concerto3 = new Concerto("Andrea Bocelli", LocalDate.of(2023, 6, 25), 2000, LocalTime.of(20, 30), new BigDecimal("90.50"));
        
		ProgrammEventi pe1 = new ProgrammEventi("Eventi musicali estivi");
		pe1.addEvent(concerto1);
		pe1.addEvent(concerto2);
		pe1.addEvent(concerto3);
		System.out.println(pe1);
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Inserisci il titolo dell'evento: ");
			String title = sc.nextLine();

			System.out.println("Inserisci la data dell'evento (formato: AAAA-MM-GG): ");
			String dateString = sc.nextLine();
			LocalDate date = LocalDate.parse(dateString);

			System.out.println("Inserisci il numero di posti totali: ");
			int numberPlacesTotal = sc.nextInt();

			sc.nextLine();

			Evento evento = new Evento(title, date, numberPlacesTotal);
			System.out.println("Evento creato: " + evento.toString());

			int numberReservations = 0;
			int numberCancellations = 0;

			System.out.println("Vuoi effettuare delle prenotazioni? (s/n): ");
			String choice = sc.nextLine();

			while (choice.equalsIgnoreCase("s")) {
				System.out.println("Inserisci il numero di prenotazioni che vuoi effettuare: ");
				int reservations = sc.nextInt();

				sc.nextLine();

				if (reservations > (evento.getNumberPlacesTotal() - evento.getNumberPlacesReserved())) {
					System.out.println("Non ci sono abbastanza posti disponibili per effettuare le prenotazioni richieste.");
					continue;
				}

				numberReservations += reservations;
				for (int i = 0; i < reservations; i++) {
					try {
						evento.reserve();
					} catch (Exception e) {
						System.out.println("Errore nella prenotazione: " + e.getMessage());
						break;
					}
				}
				System.out.println("Prenotazioni effettuate con successo: " + numberReservations);

				System.out.println("Vuoi effettuare altre prenotazioni? (s/n): ");
				choice = sc.nextLine();
			}

			System.out.println("Numeri di posti prenotati: " + evento.getNumberPlacesReserved());
			System.out.println("Numeri di posti disponibili: " + (evento.getNumberPlacesTotal() - evento.getNumberPlacesReserved()));

//	         Disdette
			System.out.println("Vuoi effettuare delle disdette? (s/n): ");
			choice = sc.nextLine();

			while (choice.equalsIgnoreCase("s")) {
				System.out.println("Inserisci il numero di posti da disdire: ");
				int cancellations = sc.nextInt();

				sc.nextLine();

				if (cancellations > numberReservations - numberCancellations) {
					System.out.println("Non puoi disdire più prenotazioni di quelle effettuate.");
					continue;
				}

				numberCancellations += cancellations;
				for (int i = 0; i < cancellations; i++) {
					try {
						evento.cancel();
					} catch (Exception e) {
						System.out.println("Errore nella disdetta: " + e.getMessage());
						break;
					}
				}
				System.out.println("Disdette effettuate con successo: " + numberCancellations);

				System.out.println("Vuoi effettuare altre disdette? (s/n): ");
				choice = sc.nextLine();
			}

			System.out.println("Numeri di posti prenotati: " + evento.getNumberPlacesReserved());
			System.out.println("Numeri di posti disponibili: " + (evento.getNumberPlacesTotal() - evento.getNumberPlacesReserved()));

		} catch (Exception e) {

			System.out.println("Errore: " + e.getMessage());
		}

		sc.close();

	}
}
