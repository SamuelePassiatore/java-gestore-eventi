package org.java.obj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	private LocalTime hour;
	private BigDecimal price;
	
	public Concerto(String title, LocalDate date, int numberPlacesTotal, LocalTime hour, BigDecimal price) throws Exception {
		super(title, date, numberPlacesTotal);
		setHour(hour);
		setPrice(price);
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getDateHourFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		return getDate().format(formatter) + " - " + hour.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public String getPriceFormatter() {
		return price.setScale(2).toString() + "€";
	}
	
	@Override
	public String toString() {
		return getDateHourFormatter() + " - " + getTitle() + " - " + getPriceFormatter();
	}

}
