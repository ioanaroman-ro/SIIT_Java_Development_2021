package dao;

import config.DataBaseManager;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public List<Customer> getAll(){
        List<Customer> customers = new ArrayList<>();
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from customers")
        ) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setBirthdate(rs.getDate("birthday").toLocalDate());

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void insert (Customer customer){
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("insert into customers (name, email, phone, birthday) values(?, ?, ?, ?)");
        ) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setDate(4, Date.valueOf(customer.getBirthdate()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update (Customer customer){
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("update customers set name = ?, email = ?, phone = ?, birthday = ? where id = ? ");
        ) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setDate(4, Date.valueOf(customer.getBirthdate()));
            ps.setInt(5, customer.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert (List<Customer> customers){
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("insert into customers (name, email, phone, birthday) values(?, ?, ?, ?)");
        ) {
            connection.setAutoCommit(false);
            for (Customer customer: customers) {
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getEmail());
                ps.setString(3, customer.getPhone());
                ps.setDate(4, Date.valueOf(customer.getBirthdate()));
                ps.addBatch();
            }
            ps.executeBatch();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Customer getBy (Integer id){
        Customer customer = null;
        try (
                Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                PreparedStatement ps = connection.prepareStatement("select * from customers where id in (?)")
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setEmail(rs.getString("email"));
            customer.setPhone(rs.getString("phone"));
            customer.setBirthdate(rs.getDate("birthday").toLocalDate());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
