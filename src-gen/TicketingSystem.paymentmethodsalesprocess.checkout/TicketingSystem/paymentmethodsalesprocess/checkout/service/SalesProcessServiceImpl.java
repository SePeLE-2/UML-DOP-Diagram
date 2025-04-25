package TicketingSystem.paymentmethodsalesprocess.checkout;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessServiceDecorator;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessImpl;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessServiceComponent;

public class SalesProcessServiceImpl extends SalesProcessServiceDecorator {
    public SalesProcessServiceImpl (SalesProcessServiceComponent record) {
        super(record);
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
