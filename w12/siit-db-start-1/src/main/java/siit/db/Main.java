package siit.db;

import dao.CustomerDao;
import model.Customer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();

        print(customers);

        Customer newCustomer = new Customer();
        newCustomer.setName("Lucian Cochior1");
        newCustomer.setPhone("083654");
        newCustomer.setEmail("l.cochior@email.com");
        newCustomer.setBirthdate(LocalDate.of(2000, 5, 21));

//        customerDao.insert(newCustomer);

        System.out.println("------------ new customer --------------");

        customers = customerDao.getAll();
        print(customers);

        Customer newCustomer2 = new Customer();
        newCustomer2.setName("Lucian Cochior2");
        newCustomer2.setPhone("08365422222");
        newCustomer2.setEmail("l.cochior2@email.com");
        newCustomer2.setBirthdate(LocalDate.of(2000, 5, 21));

        Customer newCustomer3 = new Customer();
        newCustomer3.setName("Lucian Cochior3");
        newCustomer3.setPhone("08365422222333");
        newCustomer3.setEmail("l.cochior3@email.com");
        newCustomer3.setBirthdate(LocalDate.of(2000, 5, 21));

//        customerDao.insert(Arrays.asList(newCustomer2, newCustomer3));

        print(customerDao.getAll());

        System.out.println("DBCustomer: " + customerDao.getBy(3));

        Customer updatedCustomer = customerDao.getBy(2);
        updatedCustomer.setName("Updated name");
        customerDao.update(updatedCustomer);
        System.out.println(customerDao.getBy(2));

    }

    public static void print(List<?> list) {
        System.out.println("------------------------------------------");
        for (Object elem : list) {
            System.out.println(elem);
        }
    }
}
