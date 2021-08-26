package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.ValidationException;
import siit.model.Customer;
import siit.services.CustomerService;
import siit.services.OrderService;
import siit.services.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    OrderService orderService;

    UserService userService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService, UserService userService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayCustomers(HttpSession session){
        ModelAndView mav = new ModelAndView();
        int userid = userService.getId(session);
        mav.setViewName("customers-list");
        mav.addObject("customers", customerService.getCustomers(userid));

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public ModelAndView displayCustomerEditForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customer-edit");
        mav.addObject("customer", customerService.getCustomerById(id));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/edit")
    public ModelAndView performCustomerEdit(@ModelAttribute Customer customer) {
        ModelAndView mav = new ModelAndView();
        try {
            customerService.updateCustomer(customer);
            mav.setViewName("redirect:/customers");
        } catch (ValidationException ex) {
            mav.setViewName("customer-edit");
            mav.addObject("error", ex.getMessage());
        }

        return mav;
    }

    @GetMapping("/{customer_id}/orders")
    public ModelAndView displayCustomerOrders(@PathVariable("customer_id") int customerId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer-orders");
        modelAndView.addObject("customer", customerService.getCustomerById(customerId));
        return modelAndView;
    }

    @GetMapping("/{customer_id}/orders/{order_id}/delete")
    public ModelAndView deleteCustomerOrder(@PathVariable("customer_id") int customerId, @PathVariable("order_id") int orderId){
        orderService.deleteOrderBy(orderId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer-orders");
        modelAndView.addObject("customer", customerService.getCustomerById(customerId));
        return modelAndView;
    }

    @GetMapping("/{customer_id}/orders/add")
    public ModelAndView addCustomerOrder(@PathVariable("customer_id") int customerId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer-add-order");
        modelAndView.addObject("customer", customerService.getCustomerById(customerId));
        return modelAndView;
    }

    @PostMapping("/{customer_id}/orders/add")
    public ModelAndView addNewOrder(@RequestParam String number, @RequestParam String placed, @PathVariable("customer_id") int customerId) {

        ModelAndView mav = new ModelAndView();
        try {
            orderService.insertOrder(number, placed, customerId);
            mav.setViewName("customer-orders");
            mav.addObject("customer", customerService.getCustomerById(customerId));
        } catch (ValidationException ex) {
            mav.setViewName("customer-add-order");
            mav.addObject("error", ex.getMessage());
        }

        return mav;
    }



}
