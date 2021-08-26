package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import siit.services.UserService;


@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ModelAndView displayRegisterForm(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register-account");
        return mav;
    }

    @PostMapping("/register")
   public ModelAndView insertUser(@RequestParam String userName, @RequestParam String password){
        ModelAndView mav = new ModelAndView();
        userService.createNewUser(userName,password);
        mav.setViewName("redirect:/login");
         return mav;
    }
}

