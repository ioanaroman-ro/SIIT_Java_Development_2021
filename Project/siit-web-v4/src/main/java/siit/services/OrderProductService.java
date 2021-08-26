package siit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.OrderProductDao;
import siit.db.ProductDao;
import siit.model.OrderProduct;
import siit.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    OrderProductDao orderProductDao;

    @Autowired
    ProductDao productDao;

    public OrderProduct addOrderProduct(OrderProduct orderProduct, int orderId) {
        List<OrderProduct> orderProductList = orderProductDao.getOrderProductBy(orderId);
        List<Product> existingProductsInOrder = new ArrayList<>();

        Product addedProduct = getProduct(orderProduct);
        OrderProduct addedOrderProduct;

        for (OrderProduct op : orderProductList){
            existingProductsInOrder.add(op.getProduct());
        }

        System.out.println(existingProductsInOrder);

        if (existingProductsInOrder.contains(addedProduct)){
            orderProductDao.updateOrderProductBy(orderId, addedProduct.getId(), orderProduct.getQuantity());
            addedOrderProduct=orderProductDao.getOneOrderProductBy(orderId, addedProduct.getId());
        } else {
            orderProductDao.insertOrderProduct(orderId, addedProduct.getId(), orderProduct.getQuantity());
            addedOrderProduct=orderProductDao.getOneOrderProductBy(orderId, addedProduct.getId());
        }

        return addedOrderProduct;
    }

    public Product getProduct(OrderProduct orderProduct) {
        return productDao.getProductByID(orderProduct.getProduct().getId());
    }

    public void removeOrderProduct(int orderProductId){
        orderProductDao.removeOneOrderProductBy(orderProductId);
    }


}
