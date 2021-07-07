package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siit.model.Customer;
import siit.model.Order;
import siit.model.OrderProduct;
import siit.sevices.CustomerOrderService;
import siit.sevices.CustomerService;
import siit.sevices.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;


    @GetMapping("/api/customerordersvalue")
    public BigDecimal getCustOrdVal(@RequestParam("CustID") int id ){
        return customerOrderService.getCustomerOrdersValue(id);
    }

}
