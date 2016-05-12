package com.kd.platform.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://services.kd", name = "ServicePortType")
public interface ServicePortType {
    @WebResult(name = "out", targetNamespace = "http://services.kd")
    @RequestWrapper(localName = "invoke", targetNamespace = "http://services.kd")
    @WebMethod
    @ResponseWrapper(localName = "invokeResponse", targetNamespace = "http://services.kd")
    public java.lang.String invoke(@WebParam(name = "in0", targetNamespace = "http://services.kd")
    java.lang.String in0, @WebParam(name = "in1", targetNamespace = "http://services.kd")
    java.lang.String in1, @WebParam(name = "in2", targetNamespace = "http://services.kd")
    java.lang.String in2);
}
