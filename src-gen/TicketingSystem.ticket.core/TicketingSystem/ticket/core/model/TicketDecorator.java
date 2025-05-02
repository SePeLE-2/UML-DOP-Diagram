package TicketingSystem.ticket.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class TicketDecorator extends TicketComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TicketComponent record;

	public TicketDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public TicketDecorator (TicketComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public TicketDecorator (int id, TicketComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public TicketDecorator (TicketComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public TicketDecorator() { }

	public int getId() {
		return record.getId();
	}
	public void setId(int id) {
		record.setId(id);
	}
	public String getEventName() {
		return record.getEventName();
	}
	public void setEventName(String eventName) {
		record.setEventName(eventName);
	}
	public String getTicketName() {
		return record.getTicketName();
	}
	public void setTicketName(String ticketName) {
		record.setTicketName(ticketName);
	}
	public int getPrice() {
		return record.getPrice();
	}
	public void setPrice(int price) {
		record.setPrice(price);
	}
	public String getExpiryDate() {
		return record.getExpiryDate();
	}
	public void setExpiryDate(String expiryDate) {
		record.setExpiryDate(expiryDate);
	}
	public String getPurchaseDate() {
		return record.getPurchaseDate();
	}
	public void setPurchaseDate(String purchaseDate) {
		record.setPurchaseDate(purchaseDate);
	}
	public int getAvailability() {
		return record.getAvailability();
	}
	public void setAvailability(int availability) {
		record.setAvailability(availability);
	}

	public void purchase() {
		return record.purchase();
	}

	public void refund() {
		return record.refund();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
