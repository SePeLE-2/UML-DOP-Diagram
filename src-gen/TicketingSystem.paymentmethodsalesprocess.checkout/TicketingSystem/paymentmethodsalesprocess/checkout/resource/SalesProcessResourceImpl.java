package TicketingSystem.paymentmethodsalesprocess.checkout;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessResourceDecorator;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessImpl;
import TicketingSystem.paymentmethodsalesprocess.core.SalesProcessResourceComponent;

public class SalesProcessResourceImpl extends SalesProcessResourceDecorator {
    public SalesProcessResourceImpl (SalesProcessResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/checkout/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentMethodCheckout paymentmethodcheckout = createPaymentMethodCheckout(vmjExchange);
		paymentmethodcheckoutRepository.saveObject(paymentmethodcheckout);
		return getAllPaymentMethodCheckout(vmjExchange);
	}

    public PaymentMethodSalesProcess createPaymentMethodCheckout(VMJExchange vmjExchange){
		String totalAmountStr = (String) vmjExchange.getRequestBodyForm("totalAmount");
		int totalAmount = Integer.parseInt(totalAmountStr);
		
		PaymentMethodCheckout paymentmethodcheckout = record.createPaymentMethodCheckout(vmjExchange);
		PaymentMethodCheckout paymentmethodcheckoutdeco = PaymentMethodCheckoutFactory.createPaymentMethodCheckout("TicketingSystem.checkout.core.SalesProcessImpl", paymentmethodcheckout, methodType, methodDescription
		totalAmount
		);
			return paymentmethodcheckoutdeco;
	}


    public PaymentMethodSalesProcess createPaymentMethodCheckout(VMJExchange vmjExchange, int id){
		String totalAmountStr = (String) vmjExchange.getRequestBodyForm("totalAmount");
		int totalAmount = Integer.parseInt(totalAmountStr);
		PaymentMethodCheckout paymentmethodcheckout = paymentmethodcheckoutRepository.getObject(id);
		int recordPaymentMethodCheckoutId = (((PaymentMethodCheckoutDecorator) savedPaymentMethodCheckout.getRecord()).getId();
		
		PaymentMethodCheckout paymentmethodcheckout = record.createPaymentMethodCheckout(vmjExchange);
		PaymentMethodCheckout paymentmethodcheckoutdeco = PaymentMethodCheckoutFactory.createPaymentMethodCheckout("TicketingSystem.checkout.core.SalesProcessImpl", id, paymentmethodcheckout, methodType, methodDescription
		totalAmount
		);
			return paymentmethodcheckoutdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/checkout/update")
    public HashMap<String, Object> updatePaymentMethodCheckout(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		PaymentMethodCheckout paymentmethodcheckout = paymentmethodcheckoutRepository.getObject(id);
		paymentmethodcheckout = createPaymentMethodCheckout(vmjExchange, id);
		
		paymentmethodcheckoutRepository.updateObject(paymentmethodcheckout);
		paymentmethodcheckout = paymentmethodcheckoutRepository.getObject(id);
		//to do: fix association attributes
		
		return paymentmethodcheckout.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/checkout/detail")
    public HashMap<String, Object> getPaymentMethodCheckout(VMJExchange vmjExchange){
		return record.getPaymentMethodCheckout(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/checkout/list")
    public List<HashMap<String,Object>> getAllPaymentMethodCheckout(VMJExchange vmjExchange){
		List<PaymentMethodCheckout> paymentmethodcheckoutList = paymentmethodcheckoutRepository.getAllObject("paymentmethodcheckout_impl");
		return transformPaymentMethodCheckoutListToHashMap(paymentmethodcheckoutList);
	}

    public List<HashMap<String,Object>> transformPaymentMethodCheckoutListToHashMap(List<PaymentMethodCheckout> PaymentMethodCheckoutList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentMethodCheckoutList.size(); i++) {
            resultList.add(PaymentMethodCheckoutList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/checkout/delete")
    public List<HashMap<String,Object>> deletePaymentMethodCheckout(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		paymentmethodcheckoutRepository.deleteObject(id);
		return getAllPaymentMethodCheckout(vmjExchange);
	}

	public void calculateTotal() {
		// TODO: implement this method
	}

	public void applyDiscount() {
		// TODO: implement this method
	}

	public void checkout() {
		// TODO: implement this method
	}
	
}
