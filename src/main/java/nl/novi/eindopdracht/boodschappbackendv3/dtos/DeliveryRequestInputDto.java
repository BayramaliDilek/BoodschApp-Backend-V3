package nl.novi.eindopdracht.boodschappbackendv3.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;

import java.util.List;

@Data
public class DeliveryRequestInputDto {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Long> productList;
    private String comment;

    private Status status;
    private Long applier;


    public List<Long> getProductList() {
        return productList;
    }

    public String getComment() {
        return comment;
    }

    public Long getApplier() {
        return applier;
    }

    public Status getStatus() {
        return status;
    }

}
