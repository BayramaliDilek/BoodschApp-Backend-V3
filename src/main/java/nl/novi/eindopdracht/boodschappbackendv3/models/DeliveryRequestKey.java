package nl.novi.eindopdracht.boodschappbackendv3.models;

import javax.persistence.Column;
import java.io.Serializable;

public class DeliveryRequestKey implements Serializable {

    @Column(name = "delivery_request_id")
    private Long deliveryRequestId;

    @Column(name = "product_id")
    private Long deliveryRequestProductId;




}
