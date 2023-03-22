import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class ReadTextFile {
    var textData : String=""
    init {
        textData = readText()
    }

    private fun readText() : String{
        var text : String=""
        val fileName = "C:\\JavaProject\\AlgorithmRabina-Affine\\methodClarks-Rait\\src\\main\\kotlin\\graphData.txt"
        try {
            text = Files.readAllLines(Paths.get(fileName)).toString()
        }catch(e:IOException){
            e.printStackTrace()
        }
        return text
    }
}