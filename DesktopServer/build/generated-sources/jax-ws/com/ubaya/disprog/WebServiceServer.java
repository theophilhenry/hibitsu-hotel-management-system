
package com.ubaya.disprog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceServer", targetNamespace = "http://disprog.ubaya.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceServer {


    /**
     * 
     * @param idreservation
     * @param status
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ChangeStatus")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ChangeStatus", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.ChangeStatus")
    @ResponseWrapper(localName = "ChangeStatusResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.ChangeStatusResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/ChangeStatusRequest", output = "http://disprog.ubaya.com/WebServiceServer/ChangeStatusResponse")
    public String changeStatus(
        @WebParam(name = "status", targetNamespace = "")
        String status,
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @param idreservation
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "TrackOrder1")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "TrackOrder1", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrder1")
    @ResponseWrapper(localName = "TrackOrder1Response", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrder1Response")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/TrackOrder1Request", output = "http://disprog.ubaya.com/WebServiceServer/TrackOrder1Response")
    public String trackOrder1(
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @param urlBuktiPembayaran
     * @param idreservation
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "UploadPayment")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UploadPayment", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.UploadPayment")
    @ResponseWrapper(localName = "UploadPaymentResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.UploadPaymentResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/UploadPaymentRequest", output = "http://disprog.ubaya.com/WebServiceServer/UploadPaymentResponse")
    public String uploadPayment(
        @WebParam(name = "url_bukti_pembayaran", targetNamespace = "")
        String urlBuktiPembayaran,
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @param password
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginClient")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "LoginClient", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.LoginClient")
    @ResponseWrapper(localName = "LoginClientResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.LoginClientResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/LoginClientRequest", output = "http://disprog.ubaya.com/WebServiceServer/LoginClientResponse")
    public String loginClient(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param idreservation
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "TrackOrder2")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "TrackOrder2", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrder2")
    @ResponseWrapper(localName = "TrackOrder2Response", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrder2Response")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/TrackOrder2Request", output = "http://disprog.ubaya.com/WebServiceServer/TrackOrder2Response")
    public String trackOrder2(
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @param idreservation
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayPayment")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayPayment", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayPayment")
    @ResponseWrapper(localName = "DisplayPaymentResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayPaymentResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayPaymentRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayPaymentResponse")
    public String displayPayment(
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayVillaAll")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayVillaAll", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayVillaAll")
    @ResponseWrapper(localName = "DisplayVillaAllResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayVillaAllResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayVillaAllRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayVillaAllResponse")
    public String displayVillaAll();

    /**
     * 
     * @param idvilla
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayVillaId")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayVillaId", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayVillaId")
    @ResponseWrapper(localName = "DisplayVillaIdResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayVillaIdResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayVillaIdRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayVillaIdResponse")
    public String displayVillaId(
        @WebParam(name = "idvilla", targetNamespace = "")
        Integer idvilla);

    /**
     * 
     * @param idvilla
     * @param checkin
     * @param checkout
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CheckAvailability")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CheckAvailability", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.CheckAvailability")
    @ResponseWrapper(localName = "CheckAvailabilityResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.CheckAvailabilityResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/CheckAvailabilityRequest", output = "http://disprog.ubaya.com/WebServiceServer/CheckAvailabilityResponse")
    public String checkAvailability(
        @WebParam(name = "idvilla", targetNamespace = "")
        Integer idvilla,
        @WebParam(name = "checkin", targetNamespace = "")
        String checkin,
        @WebParam(name = "checkout", targetNamespace = "")
        String checkout);

    /**
     * 
     * @param dicari
     * @param kriteria
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayReservationAll")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayReservationAll", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayReservationAll")
    @ResponseWrapper(localName = "DisplayReservationAllResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayReservationAllResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayReservationAllRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayReservationAllResponse")
    public String displayReservationAll(
        @WebParam(name = "kriteria", targetNamespace = "")
        String kriteria,
        @WebParam(name = "dicari", targetNamespace = "")
        String dicari);

    /**
     * 
     * @param idvilla
     * @param iduser
     * @param checkoutDate
     * @param notes
     * @param totalGuest
     * @param checkinDate
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "UpdateReservation")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UpdateReservation", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.UpdateReservation")
    @ResponseWrapper(localName = "UpdateReservationResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.UpdateReservationResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/UpdateReservationRequest", output = "http://disprog.ubaya.com/WebServiceServer/UpdateReservationResponse")
    public String updateReservation(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "checkin_date", targetNamespace = "")
        String checkinDate,
        @WebParam(name = "checkout_date", targetNamespace = "")
        String checkoutDate,
        @WebParam(name = "total_guest", targetNamespace = "")
        Integer totalGuest,
        @WebParam(name = "notes", targetNamespace = "")
        String notes,
        @WebParam(name = "iduser", targetNamespace = "")
        Integer iduser,
        @WebParam(name = "idvilla", targetNamespace = "")
        Integer idvilla);

    /**
     * 
     * @param idvilla
     * @param iduser
     * @param checkoutDate
     * @param notes
     * @param totalGuest
     * @param checkinDate
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertReservation")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertReservation", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.InsertReservation")
    @ResponseWrapper(localName = "InsertReservationResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.InsertReservationResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/InsertReservationRequest", output = "http://disprog.ubaya.com/WebServiceServer/InsertReservationResponse")
    public String insertReservation(
        @WebParam(name = "checkin_date", targetNamespace = "")
        String checkinDate,
        @WebParam(name = "checkout_date", targetNamespace = "")
        String checkoutDate,
        @WebParam(name = "total_guest", targetNamespace = "")
        Integer totalGuest,
        @WebParam(name = "notes", targetNamespace = "")
        String notes,
        @WebParam(name = "iduser", targetNamespace = "")
        Integer iduser,
        @WebParam(name = "idvilla", targetNamespace = "")
        Integer idvilla);

    /**
     * 
     * @param idreservation
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "TrackOrderApp")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "TrackOrderApp", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrderApp")
    @ResponseWrapper(localName = "TrackOrderAppResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.TrackOrderAppResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/TrackOrderAppRequest", output = "http://disprog.ubaya.com/WebServiceServer/TrackOrderAppResponse")
    public String trackOrderApp(
        @WebParam(name = "idreservation", targetNamespace = "")
        Integer idreservation);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayAllClient")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayAllClient", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayAllClient")
    @ResponseWrapper(localName = "DisplayAllClientResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayAllClientResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayAllClientRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayAllClientResponse")
    public String displayAllClient();

    /**
     * 
     * @param password
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginAdmin")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "LoginAdmin", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.LoginAdmin")
    @ResponseWrapper(localName = "LoginAdminResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.LoginAdminResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/LoginAdminRequest", output = "http://disprog.ubaya.com/WebServiceServer/LoginAdminResponse")
    public String loginAdmin(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param emailReceiver
     * @param emailSender
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayChat")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayChat", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayChat")
    @ResponseWrapper(localName = "DisplayChatResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayChatResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayChatRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayChatResponse")
    public String displayChat(
        @WebParam(name = "email_sender", targetNamespace = "")
        String emailSender,
        @WebParam(name = "email_receiver", targetNamespace = "")
        String emailReceiver);

    /**
     * 
     * @param iduser
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DisplayContacts")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DisplayContacts", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayContacts")
    @ResponseWrapper(localName = "DisplayContactsResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.DisplayContactsResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/DisplayContactsRequest", output = "http://disprog.ubaya.com/WebServiceServer/DisplayContactsResponse")
    public String displayContacts(
        @WebParam(name = "iduser", targetNamespace = "")
        Integer iduser);

    /**
     * 
     * @param password
     * @param phoneNumber
     * @param displayName
     * @param noKtp
     * @param fullname
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Registration")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Registration", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.Registration")
    @ResponseWrapper(localName = "RegistrationResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.RegistrationResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/RegistrationRequest", output = "http://disprog.ubaya.com/WebServiceServer/RegistrationResponse")
    public String registration(
        @WebParam(name = "fullname", targetNamespace = "")
        String fullname,
        @WebParam(name = "display_name", targetNamespace = "")
        String displayName,
        @WebParam(name = "phoneNumber", targetNamespace = "")
        String phoneNumber,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "no_ktp", targetNamespace = "")
        String noKtp);

    /**
     * 
     * @param messages
     * @param emailReceiver
     * @param emailSender
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertChat")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertChat", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.InsertChat")
    @ResponseWrapper(localName = "InsertChatResponse", targetNamespace = "http://disprog.ubaya.com/", className = "com.ubaya.disprog.InsertChatResponse")
    @Action(input = "http://disprog.ubaya.com/WebServiceServer/InsertChatRequest", output = "http://disprog.ubaya.com/WebServiceServer/InsertChatResponse")
    public String insertChat(
        @WebParam(name = "email_sender", targetNamespace = "")
        String emailSender,
        @WebParam(name = "email_receiver", targetNamespace = "")
        String emailReceiver,
        @WebParam(name = "messages", targetNamespace = "")
        String messages);

}
