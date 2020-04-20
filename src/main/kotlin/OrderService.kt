class OrderService {
    private val orders: MutableMap<String, Order> = mutableMapOf()

    fun collectOrder(order: Order) {
        orders[order.id] = order
    }

    fun findOrder(orderId: String): Order? {
        return orders[orderId]
    }
}
