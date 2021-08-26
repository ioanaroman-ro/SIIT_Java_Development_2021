package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Product;
import siit.services.ProductService;

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



    @GetMapping("/products/AddNewProduct")
    public ModelAndView addProduct(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product-add");
        return mav;
    }

    @PostMapping("/products/AddNewProduct")
    public ModelAndView insertProduct(@RequestParam String name,
                                      @RequestParam Double weight,
                                      @RequestParam Double price,
                                      @RequestParam String url){
        ModelAndView mav = new ModelAndView();
        productService.createNewProduct(name,weight,price,url);
        mav.setViewName("redirect:/products");
        return mav;
    }


}
