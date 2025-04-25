package TicketingSystem.salesprocess.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="salesprocess_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SalesProcessComponent implements SalesProcess{
	@Id
	
	public String status;
	protected String objectName = SalesProcessComponent.class.getName();

	public SalesProcessComponent() {

	} 

	public SalesProcessComponent(
        String status
    ) {
        this.status = status;
    }

	public abstract String getStatus();
	public abstract void setStatus(String status);
	
 
	public abstract void process();

	@Override
    public String toString() {
        return "{" +
            " status='" + getStatus() + "'" +
            "}";
    }
	
}
