package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.Order;
import umbcs680.ProductOrderStatePattern.OrderState;
import umbcs680.ProductOrderStatePattern.ConfirmedOrderState;
import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.DeliveredOrderState;

public class ShippedOrderState implements OrderState {
    private ProductOrder order;

    public ShippedOrderState(ProductOrder order) {
        this.order = order;
    }

    @Override
    public void confirmOrder() {
        System.out.println("Cannot confirm a shipped order.");
    }

    @Override
    public void shipOrder() {
        System.out.println("Order is already shipped.");
    }

    @Override
    public void deliverOrder() {
        order.setState(new DeliveredOrderState(order));
        System.out.println("Order is delivered.");
    }
    @Override
    public void cancelOrder() {
        System.out.println("Cannot cancel a shipped order.");
    }

    @Override
    public void returnOrder() {
        System.out.println("Order is returned.");
    }

    @Override
    public void rateOrder() {
        System.out.println("Cannot rate a shipped order.");
    }

    @Override
    public void closeOrder() {
        System.out.println("Cannot close a shipped order.");
    }
}