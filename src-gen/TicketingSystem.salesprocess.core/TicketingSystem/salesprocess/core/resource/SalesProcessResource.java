package TicketingSystem.salesprocess.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SalesProcessResource {
    List<HashMap<String,Object>> saveSalesProcess(VMJExchange vmjExchange);
    HashMap<String, Object> updateSalesProcess(VMJExchange vmjExchange);
    HashMap<String, Object> getSalesProcess(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSalesProcess(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSalesProcess(VMJExchange vmjExchange);
	HashMap<String, Object> SalesProcess(VMJExchange vmjExhange);
}
