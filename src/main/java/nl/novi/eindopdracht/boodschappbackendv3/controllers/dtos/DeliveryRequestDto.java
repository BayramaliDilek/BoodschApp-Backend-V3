package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class DeliveryRequestDto {

    public Long id;

    public List<Product> productList;

    public Status status;

    public User applier;

    public User deliverer;


    public static DeliveryRequestDto fromDeliveryRequest(DeliveryRequest deliveryRequest){
        if (deliveryRequest == null) return null;

        var dto = new DeliveryRequestDto();

        dto.id = deliveryRequest.getId();

        dto.productList = deliveryRequest.getProductList();

        dto.status = deliveryRequest.getStatus();

        dto.applier = deliveryRequest.getApplier();

        dto.deliverer = deliveryRequest.getDeliverer();

        return dto;

    }


}
