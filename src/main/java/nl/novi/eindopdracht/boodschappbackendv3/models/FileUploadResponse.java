package nl.novi.eindopdracht.boodschappbackendv3.models;

import javax.persistence.*;

@Entity
@Table(name = "picture")
public class FileUploadResponse {
//    Long id;

    @Id
    String fileName;

    String contentType;

    String url;

//    @Lob
//    byte[] data;


    @OneToOne(mappedBy = "picture")
    Product product;

    @OneToOne(mappedBy = "picture")
    User user;


    public FileUploadResponse(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public FileUploadResponse() {
    }

//    public Long getId() {
//        return id;
//    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

//    public byte[] getData() {
//        return data;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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
