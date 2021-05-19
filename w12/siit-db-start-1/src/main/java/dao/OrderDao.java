package dao;

import config.DataBaseManager;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from orders")
        ) {

            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getInt("id"));
                order.setNumber(rs.getString("number"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setPlaced(rs.getTimestamp("placed").toLocalDateTime());

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public void insert(Order order) {
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("insert into orders ( number, placed, customer_id) values(?, ?, ?)");
        ) {
            ps.setString(1, order.getNumber());
            ps.setTimestamp(2, Timestamp.valueOf(order.getPlaced()));
            ps.setInt(3, order.getCustomer_id());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Order order) {
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("update orders set number = ?, placed = ?, customer_id = ? where id = ? ");
        ) {
            ps.setString(1, order.getNumber());
            ps.setTimestamp(2, Timestamp.valueOf(order.getPlaced()));
            ps.setInt(3, order.getCustomer_id());
            ps.setInt(4, order.getOrder_id());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert(List<Order> orders) {
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("insert into orders (number, placed, customer_id) values(?, ?, ?)");
        ) {
            connection.setAutoCommit(false);
            for (Order order : orders) {
                ps.setString(1, order.getNumber());
                ps.setTimestamp(2, Timestamp.valueOf(order.getPlaced()));
                ps.setInt(3, order.getCustomer_id());
                ps.addBatch();
            }
            ps.executeBatch();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Order getBy(Integer id) {
        Order order = null;
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("select * from orders where id in (?)")
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            order = new Order();
            order.setOrder_id(rs.getInt("id"));
            order.setNumber(rs.getString("number"));
            order.setCustomer_id(rs.getInt("customer_id"));
            order.setPlaced(rs.getTimestamp("placed").toLocalDateTime());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    public List<Order> getByCustomer(Integer id) {
        List<Order> orders = new ArrayList<>();
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("select * from orders where customer_id in (?)")
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getInt("id"));
                order.setNumber(rs.getString("number"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setPlaced(rs.getTimestamp("placed").toLocalDateTime());

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;

    }
}
