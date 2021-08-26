package siit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.model.Customer;
import siit.model.Order;
import siit.model.OrderProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {
    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    public BigDecimal getCustomerOrdersValue(int id ){
        Customer customer = customerService.getCustomerById(id);
        List<Order> orders = new ArrayList<>(customer.getOrders());
        List<OrderProduct> orderProducts = new ArrayList<>();
        BigDecimal value = BigDecimal.ZERO;
        for (Order order : orders){
            orderProducts.addAll(orderService.getOrderProductBy(id, order.getId()));
        }
        for (OrderProduct op : orderProducts){
            value = value.add(op.getValue());
        }
        return value;
    }

}
