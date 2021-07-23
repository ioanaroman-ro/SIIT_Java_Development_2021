package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Product;
import siit.sevices.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getProductBy(@RequestParam("term") String term) {
        return productService.getProductsBy(term);
    }

    @GetMapping("/products")
    public ModelAndView displayProducts(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product-list");
        mav.addObject("products", productService.getProducts());

        return mav;
    }


}
