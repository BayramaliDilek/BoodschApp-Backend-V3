package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

import lombok.Data;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;

@Data
public class DeliveryRequestStatusDto {

    private Long id;

    private Status status;
}
