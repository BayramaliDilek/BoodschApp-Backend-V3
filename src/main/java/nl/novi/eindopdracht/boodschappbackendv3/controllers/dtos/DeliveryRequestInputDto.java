package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;

import java.util.List;

public class DeliveryRequestInputDto {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Long> productList;
    private String comment;

    private Status status;
    private Long applier;

//    public Person deliverer;


    public List<Long> getProductList() {
        return productList;
    }

    public void setProductList(List<Long> productList) {
        this.productList = productList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getApplier() {
        return applier;
    }

    public void setApplier(Long applier) {
        this.applier = applier;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
