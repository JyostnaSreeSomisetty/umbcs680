package umbcs680.ProductOrderStatePattern;

public interface OrderState {
    default void confirmOrder() {
    }
    default void shipOrder() {
    }
    default void deliverOrder() {
    }
    default void cancelOrder() {
    }
    default void returnOrder() {
    }
    default void rateOrder() {
    }
    default void closeOrder() {
    }
}