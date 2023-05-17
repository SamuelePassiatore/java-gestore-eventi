package org.java.obj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	private String title;
	private List<Evento> events = new ArrayList<>();
	
	public ProgrammEventi(String title) {
		setTitle(title);
    }
	
	public List<Evento> getEvents() {
		return events;
	}

	public void setEvents(List<Evento> events) {
		this.events = events;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addEvent(Evento event) {
		events.add(event);
	}
	
	public int getNumberEvents() {
        return events.size();
    }
	
	public void emptyEvents() {
		events.clear();
	}
	
	@Override
	public String toString() {

		Collections.sort(events, new Comparator<Evento>() {
			  public int compare(Evento e1, Evento e2) {
			      if (e1.getDate() == null || e2.getDate() == null)
			        return 0;
			      return e1.getDate().compareTo(e2.getDate());
			  }
			});

		String s = "";

		for(Evento event : events) {
			s += event + "\n";
		}

		return "Titolo: " + getTitle() + "\n" + s;
	}
}
