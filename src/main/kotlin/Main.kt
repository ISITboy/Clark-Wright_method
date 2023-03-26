import java.math.RoundingMode

fun main(args: Array<String>) {

    val readTxt = ReadTextFile()
    val dataGraphText = readTxt.textData

    val numberVertex = 5

    val floydsAlgo = FloydsAlgorithm(numberVertex,dataGraphText)
    floydsAlgo.readMatrixSm()

    println()


    val list : List<Double> = arrayListOf(450.0,400.0,400.0,200.0,150.0,450.0,250.0,200.0,450.0,300.0,475.0,550.0)

    val table = Array(12, { Array(12, {0.0}) })
    table[0] = arrayOf(0.0, 0.0, 6.72, 2.67, 10.80, 2.88, 0.04, 8.76, 5.68, 0.60, 13.39, 5.68)
    table[1] = arrayOf(0.0, 0.0, 2.48, 3.27, 0.78,  4.00, 7.85, 1.74, 2.06, 6.00, 0.07, 2.06)
    table[2] = arrayOf(0.0, 0.0, 0.0, 0.0,  17.20, 12.58,4.24, 23.01,0.62, 5.97, 6.36, 14.55)
    table[3] = arrayOf(0.0, 0.0, 0.0, 0.0,  0.74,  0.34, 3.37, 0.17, 8.77, 1.56, 3.88, 0.01)
    table[4] = arrayOf(0.0, 0.0, 0.0, 0.0,  0.0,   8.28, 1.57, 21.42,2.77, 3.11, 11.26,12.25)
    table[5] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0,6.15,11.23,0.00, 7.81, 2.29, 10.56)
    table[6] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.16, 2.05,8.25, 0.01, 3.36)
    table[7] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,1.43, 4.90, 8.85, 14.23)
    table[8] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.62, 7.90, 0.56)
    table[9] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.29, 5.07)
    table[10] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 5.10)
    table[11] = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0)




    val kilometerWin = KilometerWin(floydsAlgo.masSm)
    /*kilometerWin.readMatrixKWin()
    println()
    readMatrix(makeMatrixRoutAndKmWni(floydsAlgo.masSm,kilometerWin.arrayKWin))
    readMatrix(makeKmWinMatrix(table))*/

    println("Klarks")
    val k = ClarksRaytAlgo(makeKmWinMatrix(table),list)
    println(k.listWeight)


}

fun makeMatrixRoutAndKmWni(rout:Array<Array<Double>>,kmWin:Array<Array<Double>>): Array<Array<Double>>{
    var result = Array(rout.size,{Array(rout[0].size,{0.0})})
    for(i in 0 until result.size){
        for(j in 0 until result[i].size){
            if(i==j)
                result[i][j] =0.0
            else if(j>i)
                result[i][j] = rout[i][j]
            else
                result[i][j] = kmWin[i][j]
        }
    }
    return result
}

fun readMatrix(matrix:Array<Array<Double>>){
    for (i in matrix.indices) {
        println(matrix[i].contentToString())
    }
}

fun makeKmWinMatrix(matrix:Array<Array<Double>>):Array<Array<Double>>{
    var matrixResult = matrix
    for(i in 0 until matrix.size){
        for (j in 0 until matrix[i].size){
            matrixResult[j][i]=matrix[i][j]
        }
    }
    return matrixResult
}
