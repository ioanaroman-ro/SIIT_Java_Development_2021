package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.ValidationException;
import siit.model.User;
import siit.sevices.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mypersonaldata")
public class MyAccountController {


    UserService userService;

    @Autowired
    public MyAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView displayPersonalDataForm(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-change-his-personal-data");
        mav.addObject("user", userService.getUserById(userService.getId(session)));
        return mav;
    }

    @PostMapping
    public ModelAndView performPersonalDataChange(@ModelAttribute User user, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        user.setUserid(userService.getId(session));
        try {
            userService.changePersonalData(user);
            mav.setViewName("redirect:/customers");
        } catch (ValidationException ex) {
            mav.setViewName("user-change-his-personal-data");
            mav.addObject("error", ex.getMessage());
        }

        return mav;
    }

}
