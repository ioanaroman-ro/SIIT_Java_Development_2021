package siit.sevices.OrderProductDecorator;

import siit.model.OrderProduct;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderProductService {

    List<OrderProduct> getOrderProductBy(int orderId);
    OrderProduct getOneOrderProductBy(int orderId, int productId);

}
