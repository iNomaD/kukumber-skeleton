import java.time.LocalDate

class Order(val id: String) {

    lateinit var products: List<Product>
    var date: LocalDate? = null
}
