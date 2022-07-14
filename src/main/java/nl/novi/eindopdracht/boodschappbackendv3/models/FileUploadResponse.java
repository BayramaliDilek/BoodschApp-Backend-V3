package nl.novi.eindopdracht.boodschappbackendv3.models;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class FileUploadResponse {
    @Id
    Long id;

    String fileName;

    String contentType;

    String url;

//    @OneToOne(mappedBy = "image")
//    Product product;

    public FileUploadResponse(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public FileUploadResponse(String fileName, String contentType, String url, Product product) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
//        this.product = product;
    }

    public FileUploadResponse() {
    }


    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
