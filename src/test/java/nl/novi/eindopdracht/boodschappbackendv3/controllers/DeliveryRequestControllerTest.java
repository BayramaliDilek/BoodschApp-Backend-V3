package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.DeliveryRequestStatusDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.models.Status;
import nl.novi.eindopdracht.boodschappbackendv3.services.DeliveryRequestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryRequestControllerTest {

    @Mock
    private DeliveryRequestService deliveryRequestService;

    @InjectMocks
    private DeliveryRequestController deliveryRequestController;

    @Test
    @DisplayName("Should update the status of the delivery request")
    void updateDeliveryRequestWhenStatusIsUpdated() {
        DeliveryRequestStatusDto deliveryRequestStatusDto = new DeliveryRequestStatusDto();
        deliveryRequestStatusDto.setId(1L);
        deliveryRequestStatusDto.setStatus(Status.AVAILABLE);

        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setId(1L);
        deliveryRequest.setStatus(Status.FINISHED);

        deliveryRequestController.updateDeliveryRequest(1L, deliveryRequestStatusDto);

        verify(deliveryRequestService, times(1)).updateDeliveryRequest(deliveryRequestStatusDto);
    }

    @Test
    @DisplayName("Should delete the delivery request when the id is valid")
    void deleteDeliveryRequestWhenIdIsValid() {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setId(1L);

        deliveryRequestController.deleteDeliveryRequest(1L);

    }

    @Test
    @DisplayName("Should return a delivery request when the input is valid")
    void createDeliveryRequestWhenInputIsValidThenReturnDeliveryRequest() {
        DeliveryRequestInputDto deliveryRequestInputDto = new DeliveryRequestInputDto();
        DeliveryRequest deliveryRequest = new DeliveryRequest();

        when(deliveryRequestService.createDeliveryRequest(deliveryRequestInputDto))
                .thenReturn(deliveryRequest);

        DeliveryRequest result =
                deliveryRequestController.createDeliveryRequest(deliveryRequestInputDto);

        assertEquals(deliveryRequest, result);
    }

    @Test
    @DisplayName("Should return the delivery request when the id is valid")
    void getDeliveryRequestWhenIdIsValid() {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setId(1L);
        when(deliveryRequestService.getDeliveryRequest(1L)).thenReturn(deliveryRequest);

        DeliveryRequestDto deliveryRequestDto = deliveryRequestController.getDeliveryRequest(1L);

        assertEquals(1L, deliveryRequestDto.getId());
    }

    @Test
    @DisplayName("Should throw an exception when the id is invalid")
    void getDeliveryRequestWhenIdIsInvalidThenThrowsException() {
        Long id = 1L;
        when(deliveryRequestService.getDeliveryRequest(id))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(
                EntityNotFoundException.class,
                () -> deliveryRequestController.getDeliveryRequest(id));

        verify(deliveryRequestService, times(1)).getDeliveryRequest(id);
    }
}