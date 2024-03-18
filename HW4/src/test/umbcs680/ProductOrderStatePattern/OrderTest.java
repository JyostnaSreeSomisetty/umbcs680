package umbcs680.ProductOrderStatePattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import umbcs680.ProductOrderStatePattern.Order;
import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.NewOrderState;
import umbcs680.ProductOrderStatePattern.ConfirmedOrderState;
import umbcs680.ProductOrderStatePattern.ShippedOrderState;
import umbcs680.ProductOrderStatePattern.DeliveredOrderState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderTest {
    private ProductOrder order;

    @BeforeEach
    public void setUp() {
        order = new ProductOrder();
    }

    @Test
    public void testOrderConfirmationChangesState() {
        // Confirming an order should change its state to ConfirmedOrderState
        order.confirmOrder();
        assertEquals(ConfirmedOrderState.class, order.getState().getClass());
    }

    @Test
    public void testShippingChangesState() {
        // Shipping an order should change its state to ShippedOrderState
        order.confirmOrder();
        order.shipOrder();
        assertNotEquals(ProductOrder.class, order.getState().getClass());
    }

    @Test
    public void testRatingAnOrder() {
        // Rating an order should be allowed only in DeliveredOrderState
        order.confirmOrder();
        order.shipOrder();
        order.deliverOrder();
        order.rateOrder();
        // Ensure the order is still in the DeliveredOrderState
        assertEquals(DeliveredOrderState.class, order.getState().getClass());
    }

    @Test
    public void testDeliveryChangesState() {
        // Delivering an order should change its state to DeliveredOrderState
        order.confirmOrder();
        order.shipOrder();
        order.deliverOrder();
        assertNotEquals(NewOrderState.class, order.getState().getClass());
    }
}

