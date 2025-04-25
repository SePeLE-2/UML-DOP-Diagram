package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SalesProcessService {
	SalesProcess createSalesProcess(Map<String, Object> requestBody);
	SalesProcess createSalesProcess(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getSalesProcess(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveSalesProcess(Map<String, Object> requestBody);
    HashMap<String, Object> updateSalesProcess(Map<String, Object> requestBody);
    HashMap<String, Object> getSalesProcessById(int id);
    List<HashMap<String,Object>> getAllSalesProcess(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteSalesProcess(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
