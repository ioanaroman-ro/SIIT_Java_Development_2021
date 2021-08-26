package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siit.services.CustomerOrderService;

import java.math.BigDecimal;

@RestController
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;


    @GetMapping("/api/customerordersvalue")
    public BigDecimal getCustOrdVal(@RequestParam("CustID") int id ){
        return customerOrderService.getCustomerOrdersValue(id);
    }

}
