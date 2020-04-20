class SupplierService {
    private val suppliers: MutableMap<String, Supplier> = mutableMapOf()

    fun addSupplier(supplier: Supplier) {
        suppliers[supplier.supplierId] = supplier
    }

    fun findSuppliersForOrder(order: Order): List<Supplier> {
        val supliersId = order.products.map { it.supplierId }.toSet()
        return suppliers.filter { it.key in supliersId}.map { it.value }.toList()
    }
}
