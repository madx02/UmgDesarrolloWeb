package gt.edu.umg.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * TcProduct
 */
@Entity
public class TcProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull
    private String description;

    @NotNull
    private float priceUnit;

    @NotNull
    private float costUnit;


    public TcProduct() {
    }

    public TcProduct(int productId, String description, float priceUnit, float costUnit) {
        this.productId = productId;
        this.description = description;
        this.priceUnit = priceUnit;
        this.costUnit = costUnit;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceUnit() {
        return this.priceUnit;
    }

    public void setPriceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
    }

    public float getCostUnit() {
        return this.costUnit;
    }

    public void setCostUnit(float costUnit) {
        this.costUnit = costUnit;
    }

    public TcProduct productId(int productId) {
        this.productId = productId;
        return this;
    }

    public TcProduct description(String description) {
        this.description = description;
        return this;
    }

    public TcProduct priceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public TcProduct costUnit(float costUnit) {
        this.costUnit = costUnit;
        return this;
    }

    
}