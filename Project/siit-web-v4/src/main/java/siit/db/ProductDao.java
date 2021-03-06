package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Customer;
import siit.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM products order by name ASC",
                this::getProduct);

    }

    public List<Product> getProductsBy(String term) {
        return jdbcTemplate.query("SELECT * FROM products WHERE LOWER(name) LIKE ?",
                this::getProduct, "%" + term.toLowerCase() + "%");

    }


    public Product getProductByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
                this::getProduct, id);
    }

    private Product getProduct(ResultSet resultSet, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setWeight(resultSet.getBigDecimal("weight"));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setUrl(resultSet.getString("url"));

        return product;
    }

    public void addNewProduct(Product product) {
        jdbcTemplate.update("insert into products (NAME, WEIGHT, PRICE, URL) " +
                        "VALUES (?,?,?,?)",
                product.getName(), product.getWeight(), product.getPrice(), product.getUrl());
    }
}
