import database.dbQuery
import database.model.Products
import database.view.Product
import org.jetbrains.exposed.sql.batchInsert

class SynchronizationManager {

    // parse

    // pack

    suspend fun saveData(items: List<Product>) {
        val res = dbQuery {
            Products.batchInsert(items) {
                this[Products.id] = it.id
                this[Products.title] = it.title
                this[Products.description] = it.description
                this[Products.link] = it.link
                this[Products.imageLink] = it.imageLink
                this[Products.availability] = it.availability
                this[Products.price] = it.price
                this[Products.salePrice] = it.salePrice
                this[Products.googleProductCategory] = it.googleProductCategory
                this[Products.brand] = it.brand
                this[Products.condition] = it.condition
                this[Products.ageGroup] = it.ageGroup
            }
        }
    }
}