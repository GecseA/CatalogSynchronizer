package database.model

import org.jetbrains.exposed.sql.Table

object Products : Table() {

    val id = integer("id").autoIncrement()
    val title = text("title")
    val description = text("description")
    val availability = integer("availability")
    val condition = integer("condition")
    val price = integer("price")
    val salePrice = integer("sale_price")
    val link = integer("link")
    val brand = integer("brand")
    val imageLink = integer("image_link")
    val ageGroup = integer("age_group")
    val googleProductCategory = integer("google_product_category")
}