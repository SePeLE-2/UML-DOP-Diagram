package TicketingSystem.salesprocess.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="salesprocess_impl")
@Table(name="salesprocess_impl")
public class SalesProcessImpl extends SalesProcessComponent {

	public SalesProcessImpl(String status) {
		this.status = status;
	}

	public SalesProcessImpl(String status) {
		this. =  .randomUUID();;
		this.status = status;
	}

	public SalesProcessImpl() { }


	public void process() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> salesprocessMap = new HashMap<String,Object>();
		salesprocessMap.put("status",getStatus());

        return salesprocessMap;
    }

}
