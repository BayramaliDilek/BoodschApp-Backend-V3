package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface DeliveryRequestService {

    List<DeliveryRequest> getDeliveryRequests();

    DeliveryRequest getDeliveryRequest(Long id);

    DeliveryRequest createDeliveryRequest(DeliveryRequest deliveryRequest);

    void updateDeliveryRequest(DeliveryRequest deliveryRequest);

    void deleteDeliveryRequest(Long id);


}
