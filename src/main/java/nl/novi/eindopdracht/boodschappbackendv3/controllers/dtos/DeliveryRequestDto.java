package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;

import java.util.Map;

public class DeliveryRequestDto {

    private Long id;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Map<Long, String> productList;

    private Status status;

    private String comment;
    private PersonDto applier;
    private PersonDto deliverer;


    public static DeliveryRequestDto fromDeliveryRequest(DeliveryRequest deliveryRequest) {

        var dto = new DeliveryRequestDto();

        dto.setId(deliveryRequest.getId());

        dto.setProductList(deliveryRequest.getProductList());

        dto.setStatus(deliveryRequest.getStatus());

        dto.setComment(deliveryRequest.getComment());

        dto.setApplier(PersonDto.fromPerson(deliveryRequest.getApplier()));

        dto.setDeliverer(PersonDto.fromPerson(deliveryRequest.getDeliverer()));

        return dto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, String> getProductList() {
        return productList;
    }

    public void setProductList(Map<Long, String> productList) {
        this.productList = productList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PersonDto getApplier() {
        return applier;
    }

    public void setApplier(PersonDto applier) {
        this.applier = applier;
    }

    public PersonDto getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(PersonDto deliverer) {
        this.deliverer = deliverer;
    }
}
