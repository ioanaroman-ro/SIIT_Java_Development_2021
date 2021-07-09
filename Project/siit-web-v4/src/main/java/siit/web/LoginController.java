package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import siit.sevices.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    private int value = 0;

    @RequestMapping(method = RequestMethod.GET)
    protected String displayLoginForm() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    protected ModelAndView performLogin(HttpSession session,
                                        @RequestParam String user, @RequestParam String password) {

        ModelAndView mav = new ModelAndView();

        if (user.equals("admin") && password.equals("admin")) {
            session.setAttribute("logged_user", user);
            mav.setViewName("redirect:/users");
        } else {

            if (userService.checkUser(user, password)) {
                session.setAttribute("logged_user", user);
                mav.setViewName("redirect:/customers");
            } else {
                String error = "Not a registered user! ";
                mav.setViewName("login");
                mav.addObject("error", error);
            }

        }

        return mav;
    }
}
