package siit.sevices.OrderProductDecorator;

import siit.model.OrderProduct;

public abstract class OrderProductDecorator implements IOrderProductService {
    private OrderProduct orderProduct;

    public OrderProductDecorator(OrderProduct orderProduct){
        this.orderProduct = orderProduct;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }


}
