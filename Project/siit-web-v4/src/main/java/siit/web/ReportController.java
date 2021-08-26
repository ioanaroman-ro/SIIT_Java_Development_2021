package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import siit.services.ReportService;

@Controller
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/generatedReport/{customerId}/{orderId}")
    public ModelAndView generateReport(@PathVariable int customerId, @PathVariable int orderId){
        ModelAndView mav = new ModelAndView();
        reportService.generateReport(customerId, orderId);
        mav.setViewName("reportOK");
        return mav;
    }

}
