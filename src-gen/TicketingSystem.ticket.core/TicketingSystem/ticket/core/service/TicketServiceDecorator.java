package TicketingSystem.ticket.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class TicketServiceDecorator extends TicketServiceComponent{
	protected TicketServiceComponent record;

    public TicketServiceDecorator(TicketServiceComponent record) {
        this.record = record;
    }

	public TicketImpl createTicket(Map<String, Object> requestBody){
		return record.createTicket(requestBody);
	}

    public Ticket createTicket(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createTicket(requestBody, response);
	}

	public HashMap<String, Object> getTicket(Map<String, Object> requestBody){
		return record.getTicket(requestBody);
	}

	public List<HashMap<String,Object>> getAllTicket(Map<String, Object> requestBody){
		return record.getAllTicket(requestBody);
	}

    public List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange){
		return record.saveTicket(vmjExchange);
	}

    public HashMap<String, Object> updateTicket(Map<String, Object> requestBody){
		return record.updateTicket(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Ticket> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteTicket(Map<String, Object> requestBody){
		return record.deleteTicket(requestBody);
	}

	public HashMap<String, Object> getTicketById(int id){
        return record.getTicketById(id);
    }

	public void purchase() {
		return record.purchase();
	}
}
