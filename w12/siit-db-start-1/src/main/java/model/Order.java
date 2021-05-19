package model;

import java.time.LocalDateTime;

public class Order {
    private String number;
    private LocalDateTime placed;
    private Integer customer_id;
    private Integer order_id;

    public Order() {
    }

    public Order(String number, LocalDateTime placed, Integer customer_id, Integer order_id) {
        this.number = number;
        this.placed = placed;
        this.customer_id = customer_id;
        this.order_id = order_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getPlaced() {
        return placed;
    }

    public void setPlaced(LocalDateTime placed) {
        this.placed = placed;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", placed=" + placed +
                ", customer_id=" + customer_id +
                ", order_id=" + order_id +
                '}';
    }
}
