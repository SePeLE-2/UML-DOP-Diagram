package TicketingSystem.checkout.paymentmethod;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.checkout.core.SalesProcessServiceDecorator;
import TicketingSystem.checkout.core.SalesProcessImpl;
import TicketingSystem.checkout.core.SalesProcessServiceComponent;

public class SalesProcessServiceImpl extends SalesProcessServiceDecorator {
    public SalesProcessServiceImpl (SalesProcessServiceComponent record) {
        super(record);
    }

    
	public void checkout() {
		// TODO: implement this method
	}
}
