package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.ConfirmedOrderState;
import umbcs680.ProductOrderStatePattern.ShippedOrderState;
import umbcs680.ProductOrderStatePattern.OrderState;
import umbcs680.ProductOrderStatePattern.Order;


public class ConfirmedOrderState implements OrderState {
    private ProductOrder order;

    public ConfirmedOrderState(ProductOrder order) {
        this.order = order;
    }

    @Override
    public void confirmOrder() {
        System.out.println("Order is already confirmed.");
    }

    @Override
    public void shipOrder() {
        order.setState(new ShippedOrderState(order));
        System.out.println("Order is shipped.");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Cannot deliver a confirmed order.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order is canceled.");
    }

    @Override
    public void returnOrder() {
        System.out.println("Cannot return a confirmed order.");
    }

    @Override
    public void rateOrder() {
        System.out.println("Cannot rate a confirmed order.");
    }

    @Override
    public void closeOrder() {
        System.out.println("Cannot close a confirmed order.");
    }
}