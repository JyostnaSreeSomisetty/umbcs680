package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.OrderState;
import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.Order;

public class DeliveredOrderState implements OrderState {
    private ProductOrder order;

    public DeliveredOrderState(ProductOrder order) {
        this.order = order;
    }

    @Override
    public void confirmOrder() {
        System.out.println("Cannot confirm a delivered order.");
    }

    @Override
    public void shipOrder() {
        System.out.println("Cannot ship a delivered order.");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order is already delivered.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cannot cancel a delivered order.");
    }

    @Override
    public void returnOrder() {
        System.out.println("Cannot return a delivered order.");
    }

    @Override
    public void rateOrder() {
        System.out.println("Order is rated.");
    }

    @Override
    public void closeOrder() {
        System.out.println("Order is closed.");
    }
}