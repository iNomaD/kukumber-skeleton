import java.time.LocalDate

class Order(val id: String) {
    //ToDo: Add params in constructor

    lateinit var products: List<Product>
    var date: LocalDate? = null
}
