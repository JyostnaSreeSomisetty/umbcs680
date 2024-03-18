package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.OrderState;
import umbcs680.ProductOrderStatePattern.ConfirmedOrderState;
import umbcs680.ProductOrderStatePattern.Order;

public class NewOrderState implements OrderState {
    private final ProductOrder order;

    public NewOrderState(ProductOrder order) {
        this.order = order;
    }

    @Override
    public void confirmOrder() {
        order.setState(new ConfirmedOrderState(order));
        System.out.println("Order is confirmed.");
    }

    @Override
    public void shipOrder() {
        System.out.println("Cannot ship a new order.");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Cannot deliver a new order.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order is canceled.");
    }

    @Override
    public void returnOrder() {
        System.out.println("Cannot return a new order.");
    }

    @Override
    public void rateOrder() {
        System.out.println("Cannot rate a new order.");
    }

    @Override
    public void closeOrder() {
        System.out.println("Cannot close a new order.");
    }
}