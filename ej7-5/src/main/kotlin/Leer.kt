import java.io.BufferedReader
import java.io.File

class Leer(ruta: String?){
    private val file = File(ruta)
    val datos = read()
    private fun read(): MutableList<String?> = file.bufferedReader().use(BufferedReader::readLines).toMutableList()
}