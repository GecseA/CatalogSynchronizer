package database

import database.model.Products
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }

fun configureDatabases() {

    Database.connect("jdbc:sqlite:./data/products.db", "org.sqlite.JDBC")

    transaction() {
        SchemaUtils.create(Products)
        SchemaUtils.createMissingTablesAndColumns(Products)
    }
}