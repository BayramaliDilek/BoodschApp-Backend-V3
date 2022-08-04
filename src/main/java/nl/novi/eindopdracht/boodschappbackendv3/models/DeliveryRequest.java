package nl.novi.eindopdracht.boodschappbackendv3.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliveryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToMany(mappedBy = "productList",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    public List<Product> productList = new ArrayList<>();

    public Status status;


    public String comment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Person applier;

    @ManyToOne
    public Person deliverer;

    public DeliveryRequest() {
    }

    public DeliveryRequest(List<Product> productList, Person applier) {
        this.productList = productList;
        this.status = Status.AVAILABLE;
        this.applier = applier;
        this.comment = comment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
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


