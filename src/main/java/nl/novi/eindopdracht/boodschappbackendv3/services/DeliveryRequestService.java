package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestStatusDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryRequestService {

    List<DeliveryRequest> getDeliveryRequests();

    DeliveryRequest getDeliveryRequest(Long id);

//    DeliveryRequest createDeliveryRequest(DeliveryRequest deliveryRequest);

    DeliveryRequest createDeliveryRequest(DeliveryRequestInputDto deliveryRequestInputDto);

    void updateDeliveryRequest(DeliveryRequestStatusDto deliveryRequestStatusDto);

    void deleteDeliveryRequest(Long id);


}
