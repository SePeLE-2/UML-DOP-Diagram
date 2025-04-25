package TicketingSystem.salesprocess.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SalesProcessDecorator extends SalesProcessComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SalesProcessComponent record;

	public SalesProcessDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public SalesProcessDecorator (SalesProcessComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public SalesProcessDecorator (, SalesProcessComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public SalesProcessDecorator (SalesProcessComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public SalesProcessDecorator() { }


	public void process() {
		return record.process();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
