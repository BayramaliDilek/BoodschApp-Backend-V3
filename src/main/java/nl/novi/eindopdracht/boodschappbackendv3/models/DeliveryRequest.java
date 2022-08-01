package nl.novi.eindopdracht.boodschappbackendv3.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DeliveryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @OneToMany(mappedBy = "productList")
    public List<Product> productList;

    public Status status;

    @ManyToOne
    public User applier;

    @ManyToOne
    public User deliverer;

    public DeliveryRequest() {
    }

    public DeliveryRequest(List<Product> productList, User applier) {
        this.productList = productList;
        this.status = Status.PENDING;
        this.applier = applier;
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

    public User getApplier() {
        return applier;
    }

    public void setApplier(User applier) {
        this.applier = applier;
    }

    public User getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(User deliverer) {
        this.deliverer = deliverer;
    }
}


