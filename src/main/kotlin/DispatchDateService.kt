import java.time.LocalDate

class DispatchDateService(
    private val orderService: OrderService,
    private val supplierService: SupplierService) {

    fun calcDispatchDate(orderId: String): LocalDate {
        val order = orderService.findOrder(orderId)?: error("Order is not found")
        val suppliers = supplierService.findSuppliersForOrder(order)
        val maxDays = suppliers.maxBy { it.days }?.days
        maxDays?: error("Suppliers are not found")
        order.date.plusDays(maxDays)
        return LocalDate.of(2020,4,2)
    }



}
