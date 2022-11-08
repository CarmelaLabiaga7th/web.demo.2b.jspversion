package com.webshoppe.ecommerce.entity;

import java.math.BigDecimal;

public class Flower {
    private String flowerId;
    private String flowerName;
    private String flowerDescription;
    private BigDecimal flowerPrice;
    
    public Flower() {

    }

    public Flower(String flowerId, String flowerName, String flowerDescription, BigDecimal flowerPrice) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.flowerDescription = flowerDescription;
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerDescription() {
        return flowerDescription;
    }

    public void setFlowerDescription(String flowerDescription) {
        this.flowerDescription = flowerDescription;
    }

    public BigDecimal getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(BigDecimal flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

}
