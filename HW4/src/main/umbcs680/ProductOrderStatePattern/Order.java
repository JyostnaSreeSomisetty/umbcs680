package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.NewOrderState;
import umbcs680.ProductOrderStatePattern.ConfirmedOrderState;
import umbcs680.ProductOrderStatePattern.ShippedOrderState;
import umbcs680.ProductOrderStatePattern.DeliveredOrderState;

public class Order {

    public static void main(String[] args) {
        ProductOrder order = new ProductOrder();
        System.out.println("Initial state: " + order.getState().getClass().getSimpleName());

        order.confirmOrder();
        System.out.println("Current state: " + order.getState().getClass().getSimpleName());

        order.shipOrder();
        System.out.println("Current state: " + order.getState().getClass().getSimpleName());

        order.deliverOrder();
        System.out.println("Current state: " + order.getState().getClass().getSimpleName());

        order.rateOrder();
        order.closeOrder();
    }
}

