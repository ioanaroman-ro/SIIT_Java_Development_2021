package siit.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.ProductDao;
import siit.model.Customer;
import siit.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductsBy(String term){
        return productDao.getProductsBy(term);
    }

    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }


    public void createNewProduct(String name, Double weight, Double price, String url) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(price));
        product.setWeight(BigDecimal.valueOf(weight));
        product.setUrl(url);
        productDao.addNewProduct(product);
    }
}
