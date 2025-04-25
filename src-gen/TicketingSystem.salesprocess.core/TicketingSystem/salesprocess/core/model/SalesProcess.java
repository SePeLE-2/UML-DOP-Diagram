package TicketingSystem.salesprocess.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface SalesProcess {
	public String getStatus();
	public void setStatus(String status);
	org.eclipse.uml2.uml.internal.impl.ClassImpl@3f6a6c2f (name: SalesProcessImpl, visibility: <unset>) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
