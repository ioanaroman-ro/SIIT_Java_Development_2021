package siit.sevices.OrderProductDecorator;

import org.springframework.beans.factory.annotation.Autowired;
import siit.db.OrderDao;
import siit.db.OrderProductDao;
import siit.model.Discount;
import siit.model.OrderProduct;

import java.util.List;

public class OrderProductMinimDiscount extends OrderProductDecorator{
    @Autowired
    OrderProductDao orderProductDao;

    public OrderProductMinimDiscount(OrderProduct orderProduct) {
        super(orderProduct);
        orderProduct.setValue(orderProduct.getValue().multiply(Discount.MINIM.getPercent()));
    }

    public OrderProductDao getOrderProductDao() {
        return orderProductDao;
    }

    public void setOrderProductDao(OrderProductDao orderProductDao) {
        this.orderProductDao = orderProductDao;
    }

    @Override
    public List<OrderProduct> getOrderProductBy(int orderId) {
            return null;
    }

    @Override
    public OrderProduct getOneOrderProductBy(int orderId, int productId) {
        return null;
    }
}
