package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SalesProcessResourceDecorator extends SalesProcessResourceComponent{
	protected SalesProcessResourceComponent record;

    public SalesProcessResourceDecorator(SalesProcessResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange){
		return record.saveSalesProcess(vmjExchange);
	}

    public SalesProcess createSalesProcess(VMJExchange vmjExchange){
		return record.createSalesProcess(vmjExchange);
	}

    public SalesProcess createSalesProcess(VMJExchange vmjExchange, int id){
		return record.createSalesProcess(vmjExchange, id);
	}

    public HashMap<String, Object> updateSalesProcess(VMJExchange vmjExchange){
		return record.updateSalesProcess(vmjExchange);
	}

    public HashMap<String, Object> getSalesProcess(VMJExchange vmjExchange){
		return record.getSalesProcess(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSalesProcess(VMJExchange vmjExchange){
		return record.getAllSalesProcess(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteSalesProcess(VMJExchange vmjExchange){
		return record.deleteSalesProcess(vmjExchange);
	}

	public void process() {
		return record.process();
	}
}
