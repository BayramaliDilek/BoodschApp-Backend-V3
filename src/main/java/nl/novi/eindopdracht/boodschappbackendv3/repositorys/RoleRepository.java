package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}