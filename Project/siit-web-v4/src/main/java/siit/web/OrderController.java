package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siit.model.Order;
import siit.model.OrderProduct;

import siit.services.OrderProductService;
import siit.services.OrderService;


import java.util.List;

@RestController
@RequestMapping("api/customers/{customerId}/orders/{orderId}")
public class OrderController {

    @Autowired
    OrderService orderService;


    @Autowired
    OrderProductService orderProductService;

    @GetMapping
    public Order getOrderBy(@PathVariable int customerId, @PathVariable int orderId) {
        return orderService.getOrderBy(customerId, orderId);

    }

    @GetMapping("/products")
    public List<OrderProduct> getOrderProducts(@PathVariable int customerId, @PathVariable int orderId) {
        return orderService.getOrderProductBy(customerId, orderId);
    }

    @PostMapping("/products")
    public OrderProduct addProduct(@RequestBody OrderProduct orderProduct, @PathVariable int customerId, @PathVariable int orderId) {
        return orderProductService.addOrderProduct(orderProduct, orderId);
    }

    @DeleteMapping ("/products/{orderProductId}")
    public void removeProduct(@PathVariable int orderProductId) {
        orderProductService.removeOrderProduct(orderProductId);
    }

}
