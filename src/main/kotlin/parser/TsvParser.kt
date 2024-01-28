package parser

import database.view.Product
import de.siegmar.fastcsv.reader.*
import java.io.File
import java.util.function.Consumer

object TsvParser {

    val products = mutableListOf<Product>()

    fun parse(file: File) {

        CsvReader.builder()
            .fieldSeparator('\t')
            .quoteCharacter('"')
            .commentStrategy(CommentStrategy.SKIP)
            .commentCharacter('#')
            .skipEmptyLines(true)
            .detectBomHeader(false)
            .ofNamedCsvRecord(file.toPath()).forEachIndexed { index, it ->

                try {
                    val myProd = Product.fromCsvRecord(it)
                    System.out.println(it.getField(0))
                    System.out.println(myProd)
                    products.add(myProd)
                } catch(ex: IllegalArgumentException) {
                    // TODO log error
                }
        }

        /*
        val callbackHandler: CsvCallbackHandler<NamedCsvRecord> =
            NamedCsvRecordHandler("header1", "header2")

        CsvReader.builder()
            .fieldSeparator('\t')
            .quoteCharacter('"')
            .commentStrategy(CommentStrategy.SKIP)
            .commentCharacter('#')
            .skipEmptyLines(true)
            .ignoreDifferentFieldCount(false)
            .detectBomHeader(false)
            .build(callbackHandler, "field 1,field 2")
            .forEach(Consumer { rec: NamedCsvRecord -> println(rec.getField("header2")) })

         */
    }
}