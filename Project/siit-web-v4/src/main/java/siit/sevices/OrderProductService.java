package siit.sevices;

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
        OrderProduct addedOrderPoduct = new OrderProduct();

        for (OrderProduct op : orderProductList){
            existingProductsInOrder.add(op.getProduct());
        }

        if (existingProductsInOrder.contains(addedProduct)){
            orderProductDao.updateOrderProductBy(orderId, addedProduct.getId(), orderProduct.getQuantity());
            addedOrderPoduct=orderProductDao.getOneOrderProductBy(orderId, addedProduct.getId());
        } else {
            orderProductDao.insertOrderProduct(orderId, addedProduct.getId(), orderProduct.getQuantity());
            addedOrderPoduct=orderProductDao.getOneOrderProductBy(orderId, addedProduct.getId());
        }

        return addedOrderPoduct;
    }

    public Product getProduct(OrderProduct orderProduct) {
        return productDao.getProductByID(orderProduct.getProduct().getId());
    }

    public void removeOrderProduct(int orderProductId){
        orderProductDao.removeOneOrderProductBy(orderProductId);
    }


}
