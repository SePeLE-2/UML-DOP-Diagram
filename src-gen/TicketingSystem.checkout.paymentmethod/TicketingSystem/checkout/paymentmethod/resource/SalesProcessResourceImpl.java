package TicketingSystem.checkout.paymentmethod;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.checkout.core.SalesProcessResourceDecorator;
import TicketingSystem.checkout.core.SalesProcessImpl;
import TicketingSystem.checkout.core.SalesProcessResourceComponent;

public class SalesProcessResourceImpl extends SalesProcessResourceDecorator {
    public SalesProcessResourceImpl (SalesProcessResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/paymentmethod/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CheckoutPaymentMethod checkoutpaymentmethod = createCheckoutPaymentMethod(vmjExchange);
		checkoutpaymentmethodRepository.saveObject(checkoutpaymentmethod);
		return getAllCheckoutPaymentMethod(vmjExchange);
	}

    public Checkout createCheckoutPaymentMethod(VMJExchange vmjExchange){
		String methodType = (String) vmjExchange.getRequestBodyForm("methodType");
		String methodDescription = (String) vmjExchange.getRequestBodyForm("methodDescription");
		
		CheckoutPaymentMethod checkoutpaymentmethod = record.createCheckoutPaymentMethod(vmjExchange);
		CheckoutPaymentMethod checkoutpaymentmethoddeco = CheckoutPaymentMethodFactory.createCheckoutPaymentMethod("TicketingSystem.paymentmethod.core.SalesProcessImpl", checkoutpaymentmethod, totalAmount
		methodType, methodDescription
		);
			return checkoutpaymentmethoddeco;
	}


    public Checkout createCheckoutPaymentMethod(VMJExchange vmjExchange, int id){
		String methodType = (String) vmjExchange.getRequestBodyForm("methodType");
		String methodDescription = (String) vmjExchange.getRequestBodyForm("methodDescription");
		CheckoutPaymentMethod checkoutpaymentmethod = checkoutpaymentmethodRepository.getObject(id);
		int recordCheckoutPaymentMethodId = (((CheckoutPaymentMethodDecorator) savedCheckoutPaymentMethod.getRecord()).getId();
		
		CheckoutPaymentMethod checkoutpaymentmethod = record.createCheckoutPaymentMethod(vmjExchange);
		CheckoutPaymentMethod checkoutpaymentmethoddeco = CheckoutPaymentMethodFactory.createCheckoutPaymentMethod("TicketingSystem.paymentmethod.core.SalesProcessImpl", id, checkoutpaymentmethod, totalAmount
		methodType, methodDescription
		);
			return checkoutpaymentmethoddeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentmethod/update")
    public HashMap<String, Object> updateCheckoutPaymentMethod(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		CheckoutPaymentMethod checkoutpaymentmethod = checkoutpaymentmethodRepository.getObject(id);
		checkoutpaymentmethod = createCheckoutPaymentMethod(vmjExchange, id);
		
		checkoutpaymentmethodRepository.updateObject(checkoutpaymentmethod);
		checkoutpaymentmethod = checkoutpaymentmethodRepository.getObject(id);
		//to do: fix association attributes
		
		return checkoutpaymentmethod.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentmethod/detail")
    public HashMap<String, Object> getCheckoutPaymentMethod(VMJExchange vmjExchange){
		return record.getCheckoutPaymentMethod(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentmethod/list")
    public List<HashMap<String,Object>> getAllCheckoutPaymentMethod(VMJExchange vmjExchange){
		List<CheckoutPaymentMethod> checkoutpaymentmethodList = checkoutpaymentmethodRepository.getAllObject("checkoutpaymentmethod_impl");
		return transformCheckoutPaymentMethodListToHashMap(checkoutpaymentmethodList);
	}

    public List<HashMap<String,Object>> transformCheckoutPaymentMethodListToHashMap(List<CheckoutPaymentMethod> CheckoutPaymentMethodList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CheckoutPaymentMethodList.size(); i++) {
            resultList.add(CheckoutPaymentMethodList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/paymentmethod/delete")
    public List<HashMap<String,Object>> deleteCheckoutPaymentMethod(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		checkoutpaymentmethodRepository.deleteObject(id);
		return getAllCheckoutPaymentMethod(vmjExchange);
	}

	public void checkout() {
		// TODO: implement this method
	}
	
}
