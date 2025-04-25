package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.salesprocess.SalesProcessFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class SalesProcessResourceImpl extends SalesProcessResourceComponent{
	
	private SalesProcessServiceImpl salesprocessServiceImpl = new SalesProcessServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/salesprocess/save")
    public List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SalesProcess salesprocess = createSalesProcess(vmjExchange);
		salesprocessRepository.saveObject(salesprocess);
		return getAllSalesProcess(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/salesprocess")
    public HashMap<String,Object> salesprocess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SalesProcess result = salesprocessServiceImpl.createSalesProcess(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SalesProcess createSalesProcess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SalesProcess result = salesprocessServiceImpl.createSalesProcess(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SalesProcess createSalesProcess(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SalesProcess result = salesprocessServiceImpl.createSalesProcess(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/salesprocess/update")
    public HashMap<String, Object> updateSalesProcess(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return salesprocessServiceImpl.updateSalesProcess(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/salesprocess/detail")
    public HashMap<String, Object> getSalesProcess(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return salesprocessServiceImpl.getSalesProcess(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/salesprocess/list")
    public List<HashMap<String,Object>> getAllSalesProcess(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return salesprocessServiceImpl.getAllSalesProcess(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/salesprocess/delete")
    public List<HashMap<String,Object>> deleteSalesProcess(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return salesprocessServiceImpl.deleteSalesProcess(requestBody);
	}


	
	public void process() {
		// TODO: implement this method
	}
}
