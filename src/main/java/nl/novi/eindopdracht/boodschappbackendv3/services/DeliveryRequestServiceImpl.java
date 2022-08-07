package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.DeliveryRequestDto;
import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.DeliveryRequestInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.DeliveryRequestStatusDto;
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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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
    public DeliveryRequest createDeliveryRequest(DeliveryRequestInputDto deliveryRequestInputDto) {
        DeliveryRequest deliveryRequest = new DeliveryRequest();

        Map<Long, String> productList2 = new HashMap<>();
        List<Long> productListLong = deliveryRequestInputDto.getProductList();

        for (Long product : productListLong) {
            Optional<Product> optional = productRepository.findById(product);

            if (!productList2.containsKey(product)) {
                productList2.put(product, "1-" + optional.get().productName + "-" + optional.get().getPrice());
            } else {
                String[] customArr = productList2.get(product).split("-");

                int quantity =  Integer.parseInt(customArr[0]);
                int actualQuantity = quantity + 1;
//                double totalPrice =  optional.get().getPrice() * actualQuantity;
//                double roundedPrice = (Math.round(totalPrice*100)/100);

//                productList2.put(product, actualQuantity + "-" + optional.get().getProductName() + "-" + roundedPrice);

                double doubleValue =  optional.get().getPrice() * actualQuantity;
                BigDecimal bigDecimalDouble = new BigDecimal(doubleValue);

                BigDecimal bigDecimalWithScale = bigDecimalDouble.setScale(2, RoundingMode.HALF_UP);


                productList2.put(product, actualQuantity + "-" + optional.get().getProductName() + "-" + bigDecimalWithScale);

            }
        }
        deliveryRequest.setStatus(Status.AVAILABLE);
        deliveryRequest.setProductList(productList2);
        deliveryRequest.setComment(deliveryRequestInputDto.getComment());
        deliveryRequest.setApplier(personRepository.getReferenceById(deliveryRequestInputDto.getApplier()));
        return deliveryRequestRepository.save(deliveryRequest);
    }

    @Override
    public void updateDeliveryRequest(DeliveryRequestStatusDto deliveryRequestStatusDto){
        Optional<DeliveryRequest> optionalDeliveryRequest = deliveryRequestRepository.findById(deliveryRequestStatusDto.getId());
        if(optionalDeliveryRequest.isPresent()){
            optionalDeliveryRequest.get().setStatus(deliveryRequestStatusDto.getStatus());
        } else {
            throw new RecordNotFoundException("Delivery request not found");
        }
    }

//ORIGNEEELL

//    @Override
//    public DeliveryRequestDto createDeliveryRequest(DeliveryRequestInputDto deliveryRequestInputDto) {
//        DeliveryRequest deliveryRequest = new DeliveryRequest();
//        List<Product> productList = new ArrayList<>();
//        List<Long> productListLong = deliveryRequestInputDto.productList;
//        for (Long product : productListLong) {
//            Product product1 = productRepository.findById(product).orElseThrow(() -> new RecordNotFoundException("product doesnt exist"));
//            productList.add(product1);
//        }
//        deliveryRequest.setStatus(Status.AVAILABLE);
//        deliveryRequest.setProductList(productList);
//        deliveryRequest.setComment(deliveryRequestInputDto.getComment());
//        deliveryRequest.setApplier(personRepository.getReferenceById(deliveryRequestInputDto.getApplier()));
//        deliveryRequestRepository.save(deliveryRequest);
//        return DeliveryRequestDto.fromDeliveryRequest(deliveryRequest);
//    }

//    @Override
//    public DeliveryRequest createDeliveryRequest(DeliveryRequest deliveryRequest) {
//
//        for (Product product : deliveryRequest.getProductList()){
//            Optional<Product> optionalProduct = productRepository.findById(product.getId());
//
//            if (optionalProduct.isPresent()) {
//                Product product1 = optionalProduct.get();
//                product1.setProductList(deliveryRequest);
//                productRepository.save(product1);
//            }
//        }
//
//        deliveryRequest.setStatus(Status.AVAILABLE);
//
////        deliveryRequest.applier.getId();
////        Optional<Person> optionalPerson = personRepository.findById(deliveryRequest.getApplier().getId());
////
////        if (optionalPerson.isPresent()) {
////            Person person = optionalPerson.get();
////            person.addApplier(deliveryRequest);
////            personRepository.save(person);
////        }
//
//        return deliveryRequestRepository.save(deliveryRequest);
//
//    }


//    @Override
//    public void updateDeliveryRequest(DeliveryRequest deliveryRequest) {
//
//        Optional<DeliveryRequest> optionalDeliveryRequest = deliveryRequestRepository.findById(deliveryRequest.getId());
//
//        if (optionalDeliveryRequest.isEmpty()) {
//            throw new RecordNotFoundException("deliveryRequest niet gevonden");
//        } else {
//
//            DeliveryRequest deliveryRequest1 = optionalDeliveryRequest.get();
//
//            if (deliveryRequest.getStatus() != null ) {
//            deliveryRequest1.setStatus(deliveryRequest.getStatus());}
//
//            if (deliveryRequest.getDeliverer() != null ) {
//            deliveryRequest1.setDeliverer(deliveryRequest.getDeliverer()); }
//
//            deliveryRequestRepository.save(deliveryRequest1);
//
//        }
//    }

    @Override
    public void deleteDeliveryRequest(Long id){
        deliveryRequestRepository.deleteById(id);
    }

}