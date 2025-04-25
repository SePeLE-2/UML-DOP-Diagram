package TicketingSystem.salesprocess.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.salesprocess.SalesProcessFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SalesProcessServiceImpl extends SalesProcessServiceComponent{

    public List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SalesProcess salesprocess = createSalesProcess(vmjExchange);
		salesprocessRepository.saveObject(salesprocess);
		return getAllSalesProcess(vmjExchange);
	}

    public SalesProcess createSalesProcess(Map<String, Object> requestBody){
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		SalesProcess SalesProcess = SalesProcessFactory.createSalesProcess(
			"TicketingSystem.salesprocess.core.SalesProcessImpl",
		status
		);
		Repository.saveObject(salesprocess);
		return salesprocess;
	}

    public SalesProcess createSalesProcess(Map<String, Object> requestBody, int id){
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		SalesProcess salesprocess = SalesProcessFactory.createSalesProcess("TicketingSystem.salesprocess.core.SalesProcessImpl", status);
		return salesprocess;
	}

    public HashMap<String, Object> updateSalesProcess(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		SalesProcess salesprocess = Repository.getObject(id);
		
		salesprocess.setStatus((String) requestBody.get("status"));
		
		Repository.updateObject(salesprocess);
		
		//to do: fix association attributes
		
		return salesprocess.toHashMap();
		
	}

    public HashMap<String, Object> getSalesProcess(Map<String, Object> requestBody){
		List<HashMap<String, Object>> salesprocessList = getAllSalesProcess("salesprocess_impl");
		for (HashMap<String, Object> salesprocess : salesprocessList){
			int record_id = ((Double) salesprocess.get("record_id")).intValue();
			if (record_id == id){
				return salesprocess;
			}
		}
		return null;
	}

	public HashMap<String, Object> getSalesProcessById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		SalesProcess salesprocess = salesprocessRepository.getObject(id);
		return salesprocess.toHashMap();
	}

    public List<HashMap<String,Object>> getAllSalesProcess(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<SalesProcess> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SalesProcess> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteSalesProcess(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllSalesProcess(requestBody);
	}

	public void process() {
		// TODO: implement this method
	}
}
