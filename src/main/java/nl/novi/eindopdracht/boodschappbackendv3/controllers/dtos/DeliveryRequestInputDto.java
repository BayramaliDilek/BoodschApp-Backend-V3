package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

import java.util.List;

public class DeliveryRequestInputDto {


    public Long id;

    public List<Product> productList;

    public Status status;

    public String comment;

    public Person apllier;

//    public Person deliverer;



    public DeliveryRequest toDeliveryRequest() {

        var deliveryRequest = new DeliveryRequest();

        deliveryRequest.setId(id);
        deliveryRequest.setProductList(productList);
        deliveryRequest.setStatus(status);
        deliveryRequest.setComment(comment);
        deliveryRequest.setApplier(apllier);
//        deliveryRequest.setDeliverer(deliverer);

        return deliveryRequest;

    }
}
