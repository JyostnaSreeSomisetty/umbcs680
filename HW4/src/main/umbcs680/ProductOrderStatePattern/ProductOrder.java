package umbcs680.ProductOrderStatePattern;

import umbcs680.ProductOrderStatePattern.ProductOrder;
import umbcs680.ProductOrderStatePattern.OrderState;
import umbcs680.ProductOrderStatePattern.NewOrderState;
import umbcs680.ProductOrderStatePattern.Order;

public class ProductOrder {
    private OrderState state;

    public ProductOrder() {
        this.state = (OrderState) new NewOrderState(this);
    }

    public void confirmOrder() {
        state.confirmOrder();
    }

    public void shipOrder() {
        state.shipOrder();
    }

    public void deliverOrder() {
        state.deliverOrder();
    }

    public void cancelOrder() {
        state.cancelOrder();
    }

    public void returnOrder() {
        state.returnOrder();
    }

    public void rateOrder() {
        state.rateOrder();
    }

    public void closeOrder() {
        state.closeOrder();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }
}