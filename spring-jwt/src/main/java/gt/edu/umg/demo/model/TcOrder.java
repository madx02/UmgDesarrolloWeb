package gt.edu.umg.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * TcOrder
 */
@Entity
public class TcOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "FK_Client", nullable = false, updatable = false)
    private TcClient tcClient;

    @OneToMany
    @JoinColumn(name = "FK_DETAILS", nullable = false, updatable = false)
    private List<TcDetail> tcDetail;

    public TcOrder() {
    }

    public TcOrder(int orderId, TcClient tcClient, List<TcDetail> tcDetail) {
        this.orderId = orderId;
        this.tcClient = tcClient;
        this.tcDetail = tcDetail;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public TcClient getTcClient() {
        return this.tcClient;
    }

    public void setTcClient(TcClient tcClient) {
        this.tcClient = tcClient;
    }

    public List<TcDetail> getTcDetail() {
        return this.tcDetail;
    }

    public void setTcDetail(List<TcDetail> tcDetail) {
        this.tcDetail = tcDetail;
    }

    public TcOrder orderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public TcOrder tcClient(TcClient tcClient) {
        this.tcClient = tcClient;
        return this;
    }

    public TcOrder tcDetail(List<TcDetail> tcDetail) {
        this.tcDetail = tcDetail;
        return this;
    }

}