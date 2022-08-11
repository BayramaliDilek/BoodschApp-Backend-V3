package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.DeliveryRequestRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryRequestServiceImplTest {

    @Mock
    private DeliveryRequestRepository deliveryRequestRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private DeliveryRequestServiceImpl deliveryRequestService;

    @Test
    @DisplayName("Should return the delivery request when the delivery request exists")
    void getDeliveryRequestWhenDeliveryRequestExists() {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setId(1L);
        deliveryRequest.setStatus(Status.AVAILABLE);

        when(deliveryRequestRepository.findById(1L)).thenReturn(Optional.of(deliveryRequest));

        DeliveryRequest result = deliveryRequestService.getDeliveryRequest(1L);

        assertEquals(1L, result.getId());
        assertEquals(Status.AVAILABLE, result.getStatus());
    }

    @Test
    @DisplayName("Should throw an exception when the delivery request does not exist")
    void getDeliveryRequestWhenDeliveryRequestDoesNotExistThenThrowException() {
        when(deliveryRequestRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                RecordNotFoundException.class, () -> deliveryRequestService.getDeliveryRequest(1L));
    }

    @Test
    @DisplayName("Should return all delivery requests")
    void getDeliveryRequestsShouldReturnAllDeliveryRequests() {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        when(deliveryRequestRepository.findAll()).thenReturn(Arrays.asList(deliveryRequest));

        assertEquals(1, deliveryRequestService.getDeliveryRequests().size());
    }

    @Test
    @DisplayName("Should delete the delivery request when the id is found")
    void deleteDeliveryRequestWhenIdIsFound() {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setId(1L);

        deliveryRequestRepository.delete(deliveryRequest);

        deliveryRequestService.deleteDeliveryRequest(1L);

        verify(deliveryRequestRepository, times(1)).delete(deliveryRequest);

    }

    @Test
    @DisplayName("Should create a delivery request when the delivery request does not exist")
    void createDeliveryRequestWhenDeliveryRequestDoesNotExist() {
        DeliveryRequestInputDto deliveryRequestInputDto = new DeliveryRequestInputDto();

        Product product1 = new Product();
        product1.setId(1L);
        product1.setProductName("product1");
        product1.setPrice(2.0);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setProductName("product2");
        product2.setPrice(3.0);

        deliveryRequestInputDto.setProductList(Arrays.asList(1L, 2L));
        deliveryRequestInputDto.setComment("comment");
        deliveryRequestInputDto.setStatus(Status.AVAILABLE);
        deliveryRequestInputDto.setApplier(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product2));

        DeliveryRequest deliveryRequest =
                deliveryRequestService.createDeliveryRequest(deliveryRequestInputDto);

    }
}