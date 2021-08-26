package siit.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.CustomerDao;
import siit.db.OrderDao;
import siit.db.OrderProductDao;
import siit.model.Customer;
import siit.model.Order;
import siit.model.OrderProduct;

@Service
public class ReportService {

    @Autowired
    OrderProductDao orderProductDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    OrderDao orderDao;


    public void generateReport(Integer customerId, Integer orderId) {
        List<OrderProduct> orderProductList = orderProductDao.getOrderProductBy(orderId);
        Customer customer = customerDao.getCustomerById(customerId);
        Order order = orderDao.getOrderBy(orderId);
        BigDecimal value = BigDecimal.ZERO;
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("src/main/generatedReports/Report" + order.getNumber() + ".pdf"));
            document.open();
            document.add(new Paragraph("Customer: " + customer.getName()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Products for order : " + order.getNumber()
                    + " placed on " + order.getPlaced()));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Product Name / Quantity / Discount / Value"));
            for (OrderProduct op : orderProductList) {
                document.add(new Paragraph(op.getProduct().getName() + "  / "
                        + op.getQuantity() + "  / "
                        + op.getDiscount() + "  / "
                        + op.getValue()));
                value = value.add(op.getValue());
            }
            int transport = 0;

            if (value.doubleValue() >= 100){
                transport = 200;
            }

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Total order value: "));
            document.add(new Paragraph(String.valueOf(value)));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Transport: " + transport));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Total value: "));
            document.add(new Paragraph(String.valueOf(value.doubleValue() + transport)));

            document.close();
            writer.close();
        } catch (DocumentException |
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
