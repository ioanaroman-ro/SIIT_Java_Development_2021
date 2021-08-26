package siit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.ValidationException;
import siit.db.CustomerDao;
import siit.db.OrderDao;
import siit.model.Customer;
import siit.model.Order;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    OrderDao orderDao;

    public List<Customer> getCustomers(int userid) {
        return customerDao.getAllCustomers(userid);
    }

    public Customer getCustomerById(int id) {
        Customer customer = customerDao.getCustomerById(id);
        List<Order> orders = orderDao.getOrdersBy(id);

        for (Order order: orders){
            order.setValue(orderDao.calculateValue(order.getId()));
        }

        customer.setOrders(orders);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        if (customer.getPhone() != null && customer.getPhone().matches("\\+?\\d+")) {
            customerDao.updateCustomer(customer);
        } else {
            throw new ValidationException("Invalid phone number");
        }
    }

    public void createNewCustomer(String name, String phone, String email, LocalDate birthDate, int userid) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setBirthDate(birthDate);
        customerDao.addNewCustomer(customer, userid);
    }
}
