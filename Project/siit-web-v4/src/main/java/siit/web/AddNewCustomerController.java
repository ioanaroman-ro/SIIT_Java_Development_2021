package siit.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import siit.services.CustomerService;
import siit.services.UserService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class AddNewCustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @GetMapping("/addNewCustomer")
    public ModelAndView displayAddCustomerForm(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customer-add");
        return mav;
    }

    @PostMapping("/addNewCustomer")
    public ModelAndView insertCustomer(@RequestParam String name,
                                       @RequestParam String phone,
                                       @RequestParam String email,
                                       @RequestParam String birthday,
                                       HttpSession session) {
        ModelAndView mav = new ModelAndView();
        int userid = userService.getId(session);
        LocalDate birthDate = LocalDate.parse(birthday);
        customerService.createNewCustomer(name, phone, email, birthDate, userid);
        mav.setViewName("redirect:/customers");
        return mav;
    }
}
