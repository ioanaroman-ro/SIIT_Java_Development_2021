package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.OrderProduct;
import siit.model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderProductDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OrderProduct> getOrderProductBy(int orderId) {
        return jdbcTemplate.query(""
                + "SELECT  op.order_id,  op.quantity, p.name, "
                + "        op.quantity * p.price AS value, p.id as product_id, p.weight, p.price AS price "
                + "FROM ORDERS_PRODUCTS op "
                + "JOIN products p on p.id = op.product_id "
                + "WHERE op.order_id = ?", this::getOrderProduct, orderId);
    }

    public OrderProduct getOneOrderProductBy(int orderId, int productId) {
        return jdbcTemplate.queryForObject("SELECT  op.order_id,  op.quantity, p.name, "
                + "        op.quantity * p.price AS value, p.id as product_id, p.weight, p.price AS price "
                + "FROM ORDERS_PRODUCTS op "
                + "JOIN products p on p.id = op.product_id "
                + "WHERE op.order_id = ? and p.id = ?",this::getOrderProduct, orderId, productId);
    }

    public void removeOneOrderProductBy(int orderProductId) {
        jdbcTemplate.update("DELETE FROM ORDERS_PRODUCTS op WHERE op.id = ?", orderProductId);
    }

    private OrderProduct getOrderProduct(ResultSet resultSet, int rowNum) throws SQLException {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(resultSet.getInt("order_id"));
        orderProduct.setName(resultSet.getString("name"));
        orderProduct.setQuantity(resultSet.getBigDecimal("quantity"));
        orderProduct.setValue(resultSet.getBigDecimal("value"));

        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("name"));
        product.setWeight(resultSet.getBigDecimal("weight"));
        product.setPrice(resultSet.getBigDecimal("price"));

        orderProduct.setProduct(product);

        return orderProduct;
    }

    public void updateOrderProductBy(int orderId, int productId, BigDecimal quantity) {
        jdbcTemplate.update("update ORDERS_PRODUCTS op set op.quantity = op.quantity + ? where order_id = ? and product_id = ?",
                quantity, orderId, productId);

        jdbcTemplate.update("update orders_products set opvalue = " +
                "(select p.price from products p where p.id = ?) * quantity " +
                "where order_id = ?", productId, orderId);
    }

    public void insertOrderProduct(int orderId, int productId, BigDecimal quantity) {
        jdbcTemplate.update("insert into orders_products (ORDER_ID, PRODUCT_ID, QUANTITY) VALUES" +
                        "((select o.id from orders o where o.id = ?)," +
                        "(select p.id from products p where p.id = ?)," +
                        "?)",
                orderId, productId, quantity);

        jdbcTemplate.update("update orders_products set opvalue = " +
                "(select p.price from products p where p.id = ?) * quantity " +
                "where order_id = ?", productId, orderId);

        jdbcTemplate.update("update orders set value = " +
                "(select sum(opvalue) from orders_products op where op.order_id = ?)" +
                "where id = ?", orderId, orderId);
    }

}
