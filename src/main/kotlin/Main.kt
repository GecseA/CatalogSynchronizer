import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import database.configureDatabases
import database.dbQuery
import database.model.Products
import kotlinx.coroutines.launch
import org.jetbrains.exposed.sql.batchInsert
import parser.TsvParser
import java.io.File

@Composable
@Preview
fun App() {
    var scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column {
            Button(onClick = {
                text = "Hello, Desktop!"
            }) {
                Text(text)
            }
            Button(onClick = {
                TsvParser.parse(File("D:\\_TESTS\\Kotlin\\Maileon\\SENIOR BACKEND DEVELOPER - JAVA TASK\\file1.txt"))
                System.out.println(TsvParser.products)
            }) {
                Text("Load and parse")
            }
            Button(onClick = {
                val manager = SynchronizationManager()
                scope.launch {
                    manager.saveData(TsvParser.products)
                }
            }) {
                Text("Save")
            }
        }
    }
}

fun main() = application {
    configureDatabases()
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
