package TicketingSystem.ticket.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="ticket_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TicketComponent implements Ticket{
	@Id
	protected int id; 
	protected String eventName;
	protected String ticketName;
	protected int price;
	protected String expiryDate;
	protected String purchaseDate;
	protected int availability;
	protected String objectName = TicketComponent.class.getName();

	public TicketComponent() {

	} 

	public TicketComponent(
        int id, String eventName, String ticketName, int price, String expiryDate, String purchaseDate, int availability
    ) {
        this.id = id;
        this.eventName = eventName;
        this.ticketName = ticketName;
        this.price = price;
        this.expiryDate = expiryDate;
        this.purchaseDate = purchaseDate;
        this.availability = availability;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getTicketName() {
		return this.ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
 
	public abstract void purchase();

	public abstract void refund();

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " eventName='" + getEventName() + "'" +
            " ticketName='" + getTicketName() + "'" +
            " price='" + getPrice() + "'" +
            " expiryDate='" + getExpiryDate() + "'" +
            " purchaseDate='" + getPurchaseDate() + "'" +
            " availability='" + getAvailability() + "'" +
            "}";
    }
	
}
