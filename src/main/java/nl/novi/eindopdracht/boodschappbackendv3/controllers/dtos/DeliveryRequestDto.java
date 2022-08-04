package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;

import java.util.List;

public class DeliveryRequestDto {

    public Long id;

    public List<Product> productList;
    public Status status;

    public String comment;
    public PersonDto applier;
    public PersonDto deliverer;


    public static DeliveryRequestDto fromDeliveryRequest(DeliveryRequest deliveryRequest) {

        var dto = new DeliveryRequestDto();

        dto.id = deliveryRequest.getId();

        dto.productList = deliveryRequest.getProductList();

        dto.status = deliveryRequest.getStatus();

        dto.comment = deliveryRequest.getComment();

        dto.applier = PersonDto.fromPerson(deliveryRequest.getApplier());

        dto.deliverer = PersonDto.fromPerson(deliveryRequest.getDeliverer());

        return dto;

    }


}
