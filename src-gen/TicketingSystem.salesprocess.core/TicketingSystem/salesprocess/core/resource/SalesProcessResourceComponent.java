package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SalesProcessResourceComponent implements SalesProcessResource{
	
	public SalesProcessResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange);
    public abstract SalesProcess createSalesProcess(VMJExchange vmjExchange);
	public abstract SalesProcess createSalesProcess(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateSalesProcess(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getSalesProcess(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllSalesProcess(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteSalesProcess(VMJExchange vmjExchange);

	public abstract void process();
}
