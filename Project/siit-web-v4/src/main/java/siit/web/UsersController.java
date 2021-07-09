package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.ValidationException;
import siit.model.Customer;
import siit.model.User;
import siit.sevices.CustomerService;
import siit.sevices.OrderService;
import siit.sevices.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayUsers(){
        ModelAndView mav = new ModelAndView();

        System.out.println(userService.getAllUsers());

        mav.setViewName("users-list");
        mav.addObject("users", userService.getAllUsers());

        return mav;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{userid}/status")
    public ModelAndView displayUserChangeStatusForm(@PathVariable int userid) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-change-status");
        mav.addObject("user", userService.getUserById(userid));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{userid}/status")
    public ModelAndView performUserChangeStatus(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView();
        try {
            userService.changeStatus(user);
            mav.setViewName("redirect:/users");
        } catch (ValidationException ex) {
            mav.setViewName("user-change-status");
            mav.addObject("error", ex.getMessage());
        }

        return mav;
    }
//
//    @GetMapping("/{customer_id}/orders")
//    public ModelAndView displayCustomerOrders(@PathVariable("customer_id") int customerId){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("customer-orders");
//        modelAndView.addObject("customer", customerService.getCustomerById(customerId));
//
//        return modelAndView;
//    }
//
//    @GetMapping("/{customer_id}/orders/{order_id}/delete")
//    public ModelAndView deleteCustomerOrder(@PathVariable("customer_id") int customerId, @PathVariable("order_id") int orderId){
//        orderService.deleteOrderBy(orderId);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("customer-orders");
//        modelAndView.addObject("customer", customerService.getCustomerById(customerId));
//        return modelAndView;
//    }

}
