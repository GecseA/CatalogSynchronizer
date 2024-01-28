package database

import database.model.Products
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.Properties

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }

fun configureDatabases() {

    val config = DatabaseConfig()
    Database.connect(url = "jdbc:sqlite:./data/products.db", driver = "org.sqlite.JDBC", databaseConfig = config)

    transaction() {
        SchemaUtils.create(Products)
        SchemaUtils.createMissingTablesAndColumns(Products)
    }
}