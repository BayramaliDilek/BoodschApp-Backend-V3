package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Stack;

public class DeliveryRequestInputDto {


    public Long id;

    public List<Product> productList;

    public Status status;

    public User apllier;

    public User deliverer;


    public DeliveryRequest toDeliveryRequest() {

        var deliveryRequest = new DeliveryRequest();

        deliveryRequest.setId(id);
        deliveryRequest.setProductList(productList);
        deliveryRequest.setStatus(status);
        deliveryRequest.setApplier(apllier);
        deliveryRequest.setDeliverer(deliverer);

        return deliveryRequest;

    }
}
