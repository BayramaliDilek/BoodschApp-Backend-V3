package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.DeliveryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DeliveryRequestServiceImpl implements DeliveryRequestService {


    private final DeliveryRequestRepository deliveryRequestRepository;

    @Autowired
    public DeliveryRequestServiceImpl(DeliveryRequestRepository deliveryRequestRepository) {
        this.deliveryRequestRepository = deliveryRequestRepository;
    }

    @Override
    public List<DeliveryRequest> getDeliveryRequests() {
        return deliveryRequestRepository.findAll();
    }

    @Override
    public DeliveryRequest getDeliveryRequest(Long id) {
        Optional<DeliveryRequest> deliveryRequest = deliveryRequestRepository.findById(id);

        if (deliveryRequest.isPresent()) {
            return deliveryRequest.get();
        } else {
            throw new RecordNotFoundException("deliveryRequest niet gevonden");
        }

    }

    @Override
    public DeliveryRequest createDeliveryRequest(DeliveryRequest deliveryRequest) {

        deliveryRequest.setId(deliveryRequest.getId());
        deliveryRequest.setProductList(deliveryRequest.getProductList());
        deliveryRequest.setStatus(deliveryRequest.getStatus());
        deliveryRequest.setApplier(deliveryRequest.getApplier());

        return deliveryRequestRepository.save(deliveryRequest);

    }


    @Override
    public void updateDeliveryRequest(DeliveryRequest deliveryRequest) {

        Optional<DeliveryRequest> optionalDeliveryRequest = deliveryRequestRepository.findById(deliveryRequest.getId());

        if (optionalDeliveryRequest.isEmpty()) {
            throw new RecordNotFoundException("deliveryRequest niet gevonden");
        } else {

            DeliveryRequest deliveryRequest1 = optionalDeliveryRequest.get();

            if (deliveryRequest.getStatus() != null ) {
            deliveryRequest1.setStatus(deliveryRequest.getStatus());}

            if (deliveryRequest.getDeliverer() != null ) {
            deliveryRequest1.setDeliverer(deliveryRequest.getDeliverer()); }

            deliveryRequestRepository.save(deliveryRequest1);

        }
    }

    @Override
    public void deleteDeliveryRequest(Long id){
        deliveryRequestRepository.deleteById(id);
    }

}