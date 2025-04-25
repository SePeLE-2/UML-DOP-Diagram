package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SalesProcessServiceComponent implements SalesProcessService{
	protected RepositoryUtil<SalesProcess> Repository;

    public SalesProcessServiceComponent(){
        this.Repository = new RepositoryUtil<SalesProcess>(TicketingSystem.salesprocess.core.SalesProcessComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange);
    public abstract SalesProcess createSalesProcess(Map<String, Object> requestBodye);
	public abstract SalesProcess createSalesProcess(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateSalesProcess(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getSalesProcess(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllSalesProcess(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<SalesProcess> List);
    public abstract List<HashMap<String,Object>> deleteSalesProcess(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getSalesProcessById(int id);

	public abstract void process();
}
