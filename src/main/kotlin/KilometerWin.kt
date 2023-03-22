import java.math.RoundingMode
import java.text.DecimalFormat

class KilometerWin(array: Array<Array<Double>>) {

    private val arrayRout = array
    val arrayKWin : Array<Array<Double>>
    init {
        arrayKWin = algo()
    }

    fun algo():Array<Array<Double>>{
        var curArray: Array<Array<Double>>  =  Array(arrayRout.size, { Array(arrayRout[0].size, {0.0}) })
        for(i in 0 until arrayRout.size){
            for (j in 0 until arrayRout[i].size){
                var result = arrayRout[0][i]+arrayRout[0][j]-arrayRout[i][j]
                curArray[i][j] = formattingNumber(result)
            }
        }
        return curArray
    }

    fun readMatrixKWin(){
        for (i in arrayKWin.indices) {
            println(arrayKWin[i].contentToString())
        }
    }


    fun formattingNumber(number: Double) : Double =
        number.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()


}