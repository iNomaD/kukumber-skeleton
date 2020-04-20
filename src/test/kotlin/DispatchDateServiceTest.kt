import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class DispatchDateServiceTest {

    val dispatchDateService = DispatchDateService()
    val orderService = OrderService()
    val supplierService = SupplierService()

    @Test
    fun `when order date is April 1st and supplier has next day shipping then return April 2nd`() {
        val supplier = Supplier("Lenta", 1)
        supplierService.addSupplier(supplier)

        val order = Order("123")
        order.date = LocalDate.of(2020, 4, 1)
        order.products = listOf(
            Product("1", "Lenta"),
            Product("2", "Lenta")
        )
        orderService.collectOrder(order)

        val result = dispatchDateService.calcDispatchDate(order.id)
        assertEquals(LocalDate.of(2020, 4, 2), result)
    }

    @Test
    fun `when order date is April 1st and supplier has 2 day shipping then return April 3rd`() {
        val supplier = Supplier("Lenta", 2)
        supplierService.addSupplier(supplier)

        val order = Order("123")
        order.date = LocalDate.of(2020, 4, 1)
        order.products = listOf(
            Product("1", "Lenta"),
            Product("2", "Lenta")
        )
        orderService.collectOrder(order)

        val result = dispatchDateService.calcDispatchDate(order.id)
        assertEquals(LocalDate.of(2020, 4, 3), result)
    }


    //ToDo: check for weekends
}