package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.DeliveryRequestDto;
import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.DeliveryRequestInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import nl.novi.eindopdracht.boodschappbackendv3.services.DeliveryRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/deliveryRequests")
public class DeliveryRequestController {

    private final DeliveryRequestService deliveryRequestService;


    @Autowired
    public DeliveryRequestController(DeliveryRequestService deliveryRequestService) {
        this.deliveryRequestService = deliveryRequestService;
    }

    @GetMapping()
    public List<DeliveryRequestDto> getDeliveryRequests() {

        var dtos = new ArrayList<DeliveryRequestDto>();
        List<DeliveryRequest> deliveryRequestsList;

        var deliveryRequests = deliveryRequestService.getDeliveryRequests();
        for (DeliveryRequest deliveryRequest : deliveryRequests) {
            dtos.add(DeliveryRequestDto.fromDeliveryRequest(deliveryRequest));
        }
        return dtos;

    }

    @GetMapping("{id}")
    public DeliveryRequestDto getDeliveryRequest(@PathVariable("id") Long id){
        var deliveryRequest = deliveryRequestService.getDeliveryRequest(id);
        return DeliveryRequestDto.fromDeliveryRequest(deliveryRequest);
    }


    @PostMapping("/create")
    public DeliveryRequestDto createDeliveryRequest(@RequestBody DeliveryRequestInputDto dto){
        var deliveryRequest = deliveryRequestService.createDeliveryRequest(dto.toDeliveryRequest());

        return DeliveryRequestDto.fromDeliveryRequest(deliveryRequest);
    }

    @PutMapping("/{id}")
    public DeliveryRequestDto updateDeliveryRequest(@PathVariable Long id,
                                                    @RequestBody DeliveryRequest deliveryRequest){
        deliveryRequestService.updateDeliveryRequest(deliveryRequest);

        return DeliveryRequestDto.fromDeliveryRequest(deliveryRequest);
    }



    @DeleteMapping("{id}")
    public void deleteDeliveryRequest(@PathVariable("id")Long id){
        deliveryRequestService.deleteDeliveryRequest(id);
    }








}
