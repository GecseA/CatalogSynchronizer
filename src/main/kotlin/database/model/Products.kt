package database.model

import org.jetbrains.exposed.sql.Table

enum class EAvailability {
    IN_STOCK,
    OUT_OF_STOCK,
    PREORDER,
    BACKORDER,

}

object Products : Table("products") {

    val id = text("id").uniqueIndex()
    val title = text("title")
    val description = text("description")
    val link = text("link")
    val imageLink = text("image_link")
    val availability = enumeration<EAvailability>("availability")
    val price = text("price")
    val salePrice = text("sale_price").nullable()
    val googleProductCategory = text("google_product_category").nullable()
    val brand = text("brand")
    val condition = text("condition").nullable()
    val ageGroup = text("age_group").nullable()
}