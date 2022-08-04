package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.DeliveryRequestRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DeliveryRequestServiceImpl implements DeliveryRequestService {

    private final PersonRepository personRepository;
    private final DeliveryRequestRepository deliveryRequestRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DeliveryRequestServiceImpl(DeliveryRequestRepository deliveryRequestRepository,
                                      PersonRepository personRepository, ProductRepository productRepository) {
        this.deliveryRequestRepository = deliveryRequestRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
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

        for (Product product : deliveryRequest.getProductList()){
            Optional<Product> optionalProduct = productRepository.findById(product.getId());

            if (optionalProduct.isPresent()) {
                Product product1 = optionalProduct.get();
                product1.setProductList(deliveryRequest);
                productRepository.save(product1);
            }
        }

        deliveryRequest.setStatus(Status.AVAILABLE);

//        deliveryRequest.applier.getId();
//        Optional<Person> optionalPerson = personRepository.findById(deliveryRequest.getApplier().getId());
//
//        if (optionalPerson.isPresent()) {
//            Person person = optionalPerson.get();
//            person.addApplier(deliveryRequest);
//            personRepository.save(person);
//        }

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