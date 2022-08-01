package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.DeliveryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DeliveryRequestRepository extends JpaRepository<DeliveryRequest, Long>  {

    Optional<DeliveryRequest> findById(Long id);



}
