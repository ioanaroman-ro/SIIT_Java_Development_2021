package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.Customer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers(int userid){
        return jdbcTemplate.query("SELECT * FROM customers where userid = ?",
                this::getCustomer, userid);
    }

    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id = ?",
                this::getCustomer, id);
    }

    public void updateCustomer(Customer customer) {
        jdbcTemplate.update("UPDATE customers SET name=?, phone=? WHERE id=?",
                customer.getName(), customer.getPhone(), customer.getId());
    }

    private Customer getCustomer (ResultSet resultSet, int rowNum) throws SQLException{
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setBirthDate(resultSet.getDate("birthday").toLocalDate());
        return customer;
    }

    public void addNewCustomer(Customer customer, int userid) {
        Date date = Date.valueOf(customer.getBirthDate());
        jdbcTemplate.update("insert into customers (NAME, PHONE, EMAIL, BIRTHDAY, USERID) " +
                        "VALUES (?,?,?,?,?)",
                customer.getName(), customer.getPhone(), customer.getEmail(), date, userid);
    }
}
