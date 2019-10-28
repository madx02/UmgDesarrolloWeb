package gt.edu.umg.demo.model;

import java.util.List;

/**
 * OrderModel
 */
public class OrderModel {

    private TcOrder tcOrder;
    private List<TcDetail> tcDetail;


    public OrderModel() {
    }

    public OrderModel(TcOrder tcOrder, List<TcDetail> tcDetail) {
        this.tcOrder = tcOrder;
        this.tcDetail = tcDetail;
    }

    public TcOrder getTcOrder() {
        return this.tcOrder;
    }

    public void setTcOrder(TcOrder tcOrder) {
        this.tcOrder = tcOrder;
    }

    public List<TcDetail> getTcDetail() {
        return this.tcDetail;
    }

    public void setTcDetail(List<TcDetail> tcDetail) {
        this.tcDetail = tcDetail;
    }

    public OrderModel tcOrder(TcOrder tcOrder) {
        this.tcOrder = tcOrder;
        return this;
    }

    public OrderModel tcDetail(List<TcDetail> tcDetail) {
        this.tcDetail = tcDetail;
        return this;
    }
    
}