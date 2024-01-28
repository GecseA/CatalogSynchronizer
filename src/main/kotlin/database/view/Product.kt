package database.view

import database.model.EAvailability
import de.siegmar.fastcsv.reader.CsvRecord
import java.util.*

class Product(
    val id: String,
    val title: String,
    val description: String,
    val availability : EAvailability,
    val condition: String,
    val price: String,
    val salePrice: String,
    val link: String,
    val brand: String,
    val imageLink: String,
    val ageGroup: String,
    val googleProductCategory: String,
) {

    companion object {
        fun fromCsvRecord(record: CsvRecord): Product {


            return Product(
                record.getField(0),
                record.getField(1),
                record.getField(2),
                EAvailability.valueOf(
                    record.getField(3)
                        .uppercase(Locale.getDefault())
                        .replace(" ", "_")
                ),
                record.getField(4),
                record.getField(5),
                record.getField(6),
                record.getField(7),
                record.getField(8),
                record.getField(9),
                record.getField(10),
                record.getField(11),
            )
        }
    }
}