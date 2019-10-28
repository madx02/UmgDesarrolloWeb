package gt.edu.umg.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * TcDetail
 */
@Entity
public class TcDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;

    @NotNull
    private int cantidad;

    @NotNull
    private Double costUnit;

    @NotNull
    private Double priceUnit;

    // @ManyToOne
    // @JoinColumn(name = "FK_Order")
    // private TcOrder tcOrder;

    @ManyToOne
    @JoinColumn(name = "FK_Product")
    private TcProduct tcProduct;


    public TcDetail() {
    }

    public TcDetail(int detailId, int cantidad, Double costUnit, Double priceUnit, TcProduct tcProduct) {
        this.detailId = detailId;
        this.cantidad = cantidad;
        this.costUnit = costUnit;
        this.priceUnit = priceUnit;
        this.tcProduct = tcProduct;
    }

    public int getDetailId() {
        return this.detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostUnit() {
        return this.costUnit;
    }

    public void setCostUnit(Double costUnit) {
        this.costUnit = costUnit;
    }

    public Double getPriceUnit() {
        return this.priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public TcProduct getTcProduct() {
        return this.tcProduct;
    }

    public void setTcProduct(TcProduct tcProduct) {
        this.tcProduct = tcProduct;
    }

    public TcDetail detailId(int detailId) {
        this.detailId = detailId;
        return this;
    }

    public TcDetail cantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public TcDetail costUnit(Double costUnit) {
        this.costUnit = costUnit;
        return this;
    }

    public TcDetail priceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public TcDetail tcProduct(TcProduct tcProduct) {
        this.tcProduct = tcProduct;
        return this;
    }

}