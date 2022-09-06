package nl.novi.eindopdracht.boodschappbackendv3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

@Entity
public class DeliveryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "json")
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Map<Long, String> productList;

    private Status status;

    private String comment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person applier;

    @JsonIgnore
    @ManyToOne
    private Person deliverer;

    public DeliveryRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Map<Long, String> getProductList() {
        return productList;
    }

    public void setProductList(Map<Long, String> productList) {
        this.productList = productList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person getApplier() {
        return applier;
    }

    public void setApplier(Person applier) {
        this.applier = applier;
    }

    public Person getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Person deliverer) {
        this.deliverer = deliverer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


