package edu.mum.coffee.DTO;

/**
 * Created by Hatake on 6/21/2017.
 */
public class OrderLineDTO {

    private int quantity;

    private int productId;

    private int orderId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
