package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Discount;
import siit.model.OrderProduct;
import siit.model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderProductDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OrderProduct> getOrderProductBy(int orderId) {
        return jdbcTemplate.query(""
                + "SELECT  op.id,  op.order_id, op.quantity, p.name, "
                + "        op.discount, op.quantity * p.price * op.discount AS value, p.id as product_id, "
                + "p.weight, p.price AS price, p.url as image "
                + "FROM ORDERS_PRODUCTS op "
                + "JOIN products p on p.id = op.product_id "
                + "WHERE op.order_id = ? order by p.name ASC", this::getOrderProduct, orderId);
    }

    public OrderProduct getOneOrderProductBy(int orderId, int productId) {
        OrderProduct orderProduct = jdbcTemplate.queryForObject("SELECT  op.id, op.order_id,  op.quantity, p.name, "
                + "op.discount, op.quantity * p.price * op.discount AS value, p.id as product_id, p.weight, "
                + "p.price AS price, p.url as image "
                + "FROM ORDERS_PRODUCTS op "
                + "JOIN products p on p.id = op.product_id "
                + "WHERE op.order_id = ? and p.id = ?", this::getOrderProduct, orderId, productId);

        return orderProduct;
    }

    public void removeOneOrderProductBy(int orderProductId) {
        jdbcTemplate.update("DELETE FROM ORDERS_PRODUCTS WHERE id = ?", orderProductId);
    }

    private OrderProduct getOrderProduct(ResultSet resultSet, int rowNum) throws SQLException {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(resultSet.getInt("id"));
        orderProduct.setOrderId(resultSet.getInt("order_id"));
        orderProduct.setName(resultSet.getString("name"));
        orderProduct.setQuantity(resultSet.getBigDecimal("quantity"));
        orderProduct.setDiscount(resultSet.getBigDecimal("discount"));
        orderProduct.setValue(resultSet.getBigDecimal("value"));

        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("name"));
        product.setWeight(resultSet.getBigDecimal("weight"));
        product.setPrice(resultSet.getBigDecimal("price"));


        product.setUrl(resultSet.getString("url"));

        orderProduct.setProduct(product);

        return orderProduct;
    }

    public void updateOrderProductBy(int orderId, int productId, BigDecimal quantity) {
        BigDecimal totalQuantity = getOneOrderProductBy(orderId,productId).getQuantity().add(quantity);
        if(totalQuantity.doubleValue() >= 5){
            updateDiscount(orderId, productId, totalQuantity);
        }
        jdbcTemplate.update("update ORDERS_PRODUCTS op set op.quantity = op.quantity + ?" +
                        "where order_id = ? and product_id = ?",
                quantity, orderId, productId);
    }

    private void updateDiscount(int orderId, int productId, BigDecimal quantity) {
        jdbcTemplate.update("update ORDERS_PRODUCTS op set op.discount = ?" +
                        "where order_id = ? and product_id = ?",
                applyDiscountOnQuantity(quantity), orderId, productId);
    }

    public void insertOrderProduct(int orderId, int productId, BigDecimal quantity) {
        BigDecimal discount = applyDiscountOnQuantity(quantity);
        jdbcTemplate.update("insert into orders_products (ORDER_ID, PRODUCT_ID, QUANTITY, DISCOUNT) VALUES" +
                        "((select o.id from orders o where o.id = ?)," +
                        "(select p.id from products p where p.id = ?)," +
                        "? , ?)",
                orderId, productId, quantity, discount);

    }

    private BigDecimal applyDiscountOnQuantity(BigDecimal quantity) {
        BigDecimal valueOfDiscount = BigDecimal.valueOf(1);
        if (quantity.doubleValue() > Discount.MINIM.getMinQuantityForDiscount()
                && quantity.doubleValue() < Discount.MEDIUM.getMinQuantityForDiscount()){
            valueOfDiscount = Discount.MINIM.getPercent();
        }
        if (quantity.doubleValue() >= Discount.MEDIUM.getMinQuantityForDiscount()
                && quantity.doubleValue() < Discount.MAXIMUM.getMinQuantityForDiscount()){
            valueOfDiscount = Discount.MEDIUM.getPercent();
        }
        if (quantity.doubleValue() >= Discount.MAXIMUM.getMinQuantityForDiscount()) {
            valueOfDiscount = Discount.MAXIMUM.getPercent();
        }
        return valueOfDiscount;
    }

}
