package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import siit.ValidationException;
import siit.model.User;
import siit.services.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myresetpass")
public class MyPasswordController {

    UserService userService;

    @Autowired
    public MyPasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView displayPersonalDataForm(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-reset-his-password");
        mav.addObject("user", userService.getUserById(userService.getId(session)));
        return mav;
    }

    @PostMapping
    public ModelAndView performPersonalDataChange(@ModelAttribute User user, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        user.setUserid(userService.getId(session));
        try {
            userService.changePassword(user);
            mav.setViewName("redirect:/customers");
        } catch (ValidationException ex) {
            mav.setViewName("user-reset-his-password");
            mav.addObject("error", ex.getMessage());
        }

        return mav;
    }
}
