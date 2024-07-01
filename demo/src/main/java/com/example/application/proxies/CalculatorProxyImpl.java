package com.example.application.proxies;

import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.domains.contracts.proxies.CalculatorProxy;
import com.example.webservices.schemas.calculator.AddRequest;
import com.example.webservices.schemas.calculator.AddResponse;
import com.example.webservices.schemas.calculator.DivRequest;
import com.example.webservices.schemas.calculator.DivResponse;
import com.example.webservices.schemas.calculator.MulRequest;
import com.example.webservices.schemas.calculator.MulResponse;
import com.example.webservices.schemas.calculator.SubRequest;
import com.example.webservices.schemas.calculator.SubResponse;

public class CalculatorProxyImpl extends WebServiceGatewaySupport implements CalculatorProxy {
	private static final WebServiceMessageCallback requestCallback = new SoapActionCallback("http://example.com/webservices/schemas/calculator");

	@Override
	public double add(double a, double b) {
		var request = new AddRequest();
		request.setOp1(a);
		request.setOp2(b);
		var response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request, requestCallback);
		return response.getAddResult();
	}

	@Override
	public double subtract(double a, double b) {
		var request = new SubRequest();
		request.setOp1(a);
		request.setOp2(b);
		var response = (SubResponse) getWebServiceTemplate().marshalSendAndReceive(request, requestCallback);
		return response.getSubResult();
	}

	@Override
	public double multiply(double a, double b) {
		var request = new MulRequest();
		request.setOp1(a);
		request.setOp2(b);
		var response = (MulResponse) getWebServiceTemplate().marshalSendAndReceive(request, requestCallback);
		return response.getMulResult();
	}

	@Override
	public double divide(double a, double b) {
		var request = new DivRequest();
		request.setOp1(a);
		request.setOp2(b);
		var response = (DivResponse) getWebServiceTemplate().marshalSendAndReceive(request, requestCallback);
		return response.getDivResult();
	}

}
