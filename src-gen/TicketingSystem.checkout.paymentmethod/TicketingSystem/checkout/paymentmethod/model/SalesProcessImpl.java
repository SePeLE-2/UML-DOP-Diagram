package TicketingSystem.checkout.paymentmethod;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.checkout.core.SalesProcessDecorator;
import TicketingSystem.checkout.core.SalesProcess;
import TicketingSystem.checkout.core.SalesProcessComponent;

@Entity(name="checkout_paymentmethod")
@Table(name="checkout_paymentmethod")
public class SalesProcessImpl extends SalesProcessDecorator {

	public String methodType;
	public String methodDescription;
	public SalesProcessImpl(
        super();
        this.objectName = SalesProcessImpl.class.getName();
    }
    
    public SalesProcessImpl(String methodType, String methodDescription) {
    	super();
		this.methodType = methodType;
		this.methodDescription = methodDescription;
		this.objectName = SalesProcessImpl.class.getName();
    }
	
	public SalesProcessImpl(SalesProcessComponent record, String methodType, String methodDescription) {
		super(record);
		this.methodType = methodType;
		this.methodDescription = methodDescription;
		this.objectName = SalesProcessImpl.class.getName();
	}


	public void checkout() {
		// TODO: implement this method
	}

}
