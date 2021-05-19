package siit.db;

import dao.OrderDao;
import model.Order;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class OrderMain {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getAll();

        print(orders);

//        Order newOrder = new Order();
//        newOrder.setNumber("AAA982774");
//        newOrder.setPlaced(LocalDateTime.of(2021, 04, 15, 21, 30, 30));
//        newOrder.setCustomer_id(2);

//        orderDao.insert(newOrder);

//        System.out.println("------------ new order --------------");
//
//        orders = orderDao.getAll();
//        print(orders);
//
//        Order newOrder2 = new Order();
//        newOrder2.setNumber("BBB982774");
//        newOrder2.setPlaced(LocalDateTime.of(2021, 04, 15, 20, 30, 30));
//        newOrder2.setCustomer_id(3);
//
//        Order newOrder3 = new Order();
//        newOrder3.setNumber("CCC982774");
//        newOrder3.setPlaced(LocalDateTime.of(2021, 04, 15, 19, 30, 30));
//        newOrder3.setCustomer_id(3);
//
//        orderDao.insert(Arrays.asList(newOrder2, newOrder3));
//
//        print(orderDao.getAll());

//        System.out.println("DBOrder: " + orderDao.getBy(10));
//
//        Order updatedOrder= orderDao.getBy(2);
//        updatedOrder.setNumber("DDD982774");
//        orderDao.update(updatedOrder);
//        System.out.println(orderDao.getBy(2));

        List<Order> ordersByCustomer = orderDao.getByCustomer(1);
        print(ordersByCustomer);

    }

    public static void print(List<?> list) {
        System.out.println("------------------------------------------");
        for (Object elem : list) {
            System.out.println(elem);
        }
    }
}
