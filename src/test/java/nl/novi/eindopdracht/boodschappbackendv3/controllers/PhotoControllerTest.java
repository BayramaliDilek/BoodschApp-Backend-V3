package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.services.PhotoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhotoControllerTest {

    @Mock
    private PhotoService photoService;

    @InjectMocks
    private PhotoController photoController;

    private String fileStorageLocation = "src/test/resources/";


    @Test
    @DisplayName("Should throw an exception when the file does not exist")
    void downLoadSingleFileWhenFileDoesNotExistThenThrowException() {
        String fileName = "test.txt";
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(photoService.downLoadFile(fileName))
                .thenThrow(new RuntimeException("the file doesn't exist or not readable"));

        assertThrows(
                RuntimeException.class,
                () -> photoController.downLoadSingleFile(fileName, request));
    }
}