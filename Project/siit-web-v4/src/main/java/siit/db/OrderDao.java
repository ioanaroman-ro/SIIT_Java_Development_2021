package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Customer;
import siit.model.Order;
import siit.model.OrderProduct;
import siit.model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderProductDao orderProductDao;

    public List<Order> getOrdersBy(int customerId) {
        return jdbcTemplate.query("SELECT * FROM orders WHERE customer_id = ? order by placed ASC",
                this::getOrder, customerId);
    }

    public void deleteOrderBy(int orderId) {

        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", orderId);
    }

    public void deleteOrderProduct(int orderId) {
        jdbcTemplate.update("DELETE FROM orders_products WHERE order_id = ?", orderId);
    }

    public void insertOrder(Order order, int customerId) {

        jdbcTemplate.update("INSERT INTO ORDERS (number, placed, customer_id) VALUES (?,?,?)", order.getNumber(), order.getPlaced(), customerId);
    }

    private Order getOrder(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setNumber(resultSet.getString("number"));
        order.setPlaced(resultSet.getTimestamp("placed").toLocalDateTime());
        return order;
    }


    public double calculateValue(int orderid) {

        BigDecimal value = BigDecimal.ZERO;

        List<OrderProduct> orderProducts = new ArrayList<>(orderProductDao.getOrderProductBy(orderid));

        for (OrderProduct op : orderProducts) {
            value = value.add(op.getValue());
        }
        return value.doubleValue();

    }

    public Order getOrderBy(Integer orderId) {
        return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = ?",
                this::getOrder, orderId);
    }
}
