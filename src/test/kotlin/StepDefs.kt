import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import java.time.LocalDate
import kotlin.test.assertEquals

class StepDefs : En {

    lateinit var order: Order
    lateinit var supplier: Supplier
    private val dispatchDateService: DispatchDateService = DispatchDateService()

    init {
        Given("I have Order") {
            order = Order("order1")
        }
        Given("Order date is {int}\\/{int}\\/{int}") { day: Int, month: Int, year: Int ->
            order.date = LocalDate.of(year, month, day)
        }
        Given("Order consists of products") { dataTable: DataTable ->
            order.products = dataTable.asLists().map { Product(it[0], it[1]) }
        }
        Given("Order is collected") {
            dispatchDateService.collectOrder(order)
        }
        When("Supplier {string} has lead time {int} day") { supplierId: String, days: Int ->
            //todo add supplier to dispatch service
            supplier = Supplier(supplierId, days)
        }
        Then("Order dispatched date is {int}\\/{int}\\/{int}") { day: Int, month: Int, year: Int ->
            assertEquals(LocalDate.of(year, month, day), dispatchDateService.calcDispatchDate("order1"))
        }

    }
}