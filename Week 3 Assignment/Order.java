public class Order {
    static int totalOrders = 0;

    public Order() {
        totalOrders++;
    }

    public static void main(String[] args) {
        new Order();
        new Order();
        new Order();
        new Order();

        System.out.println("Total orders: " + Order.totalOrders);
    }
}
