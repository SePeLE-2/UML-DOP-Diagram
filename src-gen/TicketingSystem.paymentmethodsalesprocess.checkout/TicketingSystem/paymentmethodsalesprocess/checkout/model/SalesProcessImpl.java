package TicketingSystem.paymentmethodsalesprocess.checkout;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessDecorator;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcess;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessComponent;

@Entity(name="paymentmethodsalesprocess_checkout")
@Table(name="paymentmethodsalesprocess_checkout")
public class SalesProcessImpl extends SalesProcessDecorator {

	public int totalAmount;
	public SalesProcessImpl(
        super();
        this.objectName = SalesProcessImpl.class.getName();
    }
    
    public SalesProcessImpl(int totalAmount) {
    	super();
		this.totalAmount = totalAmount;
		this.objectName = SalesProcessImpl.class.getName();
    }
	
	public SalesProcessImpl(SalesProcessComponent record, int totalAmount) {
		super(record);
		this.totalAmount = totalAmount;
		this.objectName = SalesProcessImpl.class.getName();
	}


	public void calculateTotal() {
		// TODO: implement this method
	}

	public void applyDiscount() {
		// TODO: implement this method
	}

	public void checkout() {
		// TODO: implement this method
	}

}
