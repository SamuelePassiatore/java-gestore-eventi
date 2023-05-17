package org.java.obj;

import java.time.LocalDate;

public class Evento {
	
    private String title;
    private LocalDate date;
    private int numberPlacesTotal;
    private int numberPlacesReserved;
    
    public Evento(String title, LocalDate date, int numberPlacesTotal) throws Exception {
  
    	setTitle(title);
    	setDate(date);
    	this.numberPlacesTotal = numberPlacesTotal;
    	this.numberPlacesReserved = 0;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) throws Exception {
		if(date.isBefore(LocalDate.now())) {
			 throw new Exception("La data non può essere nel passato.");
		}
		this.date = date;
	}

	public int getNumberPlacesTotal() {
		return numberPlacesTotal;
	}
	
	public void setNumberPlacesTotal(int numberPlacesTotal) throws Exception {
		if(numberPlacesTotal <= 0) {
			 throw new Exception("Il numero di posti totali dev'essere positivo");
		}
		this.numberPlacesTotal = numberPlacesTotal;
	}

	public int getNumberPlacesReserved() {
		return numberPlacesReserved;
	}
	
	public void reserve() throws Exception {
		
		if(date.isBefore(LocalDate.now())) {
			 throw new Exception("L'evento è già passato");
		}
		
		if(numberPlacesReserved >= numberPlacesTotal) {
			 throw new Exception("Non ci sono posti disponibili per prenotare.");
		}
		
		numberPlacesReserved++;
	}
	
	public void cancel() throws Exception {
		
		if(date.isBefore(LocalDate.now())) {
			 throw new Exception("L'evento è già passato");
		}
		
		if(numberPlacesReserved <= 0) {
			 throw new Exception("Non ci sono prenotazioni da disdire.");
		}
		
		numberPlacesReserved--;
	}
	
	@Override
	public String toString() {
		
		return date.toString() + " - " + title;
	}
}
