package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface FileUploadRepository extends JpaRepository<FileUploadResponse, String> {

//    FileUploadResponse findByNameEquals(String fileName);

    Optional<FileUploadResponse> findByFileNameEqualsIgnoreCase(String fileName);

//    Stream<FileUploadResponse> getPictures();
}
