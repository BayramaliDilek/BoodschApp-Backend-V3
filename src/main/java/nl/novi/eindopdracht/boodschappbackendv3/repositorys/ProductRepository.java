package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findById(Long id);

}
