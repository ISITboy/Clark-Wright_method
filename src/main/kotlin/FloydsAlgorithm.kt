class FloydsAlgorithm (val n :Int, val textData:String){
    var masSm : Array<Array<Double>> = Array(n,{Array(n,{Int.MAX_VALUE.toDouble()})})

    init {
        inputDataBond()
        masWriteNulls()
        algo()
    }
    private fun algo(){
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if((masSm[i][j]> masSm[i][k]+masSm[k][j])&&masSm[i][k]<Int.MAX_VALUE&&masSm[k][j]<Int.MAX_VALUE){
                        masSm[i][j] = masSm[i][k]+masSm[k][j]
                    }
                }
            }
        }
    }

    private fun inputDataBond(){

        val numbers = Regex("[0-9]+").findAll(textData)
            .map(MatchResult::value)
            .toList()
        for (i in 0 until numbers.size step 3){
            masSm[numbers[i].toInt()][numbers[i+1].toInt()]=numbers[i+2].toDouble()
            masSm[numbers[i+1].toInt()][numbers[i].toInt()]=numbers[i+2].toDouble()
        }

    }

    private fun masWriteNulls(){
        for (i in 0 until n){
            masSm[i][i] = 0.0
        }
    }

    fun readMatrixSm(){
        for (i in masSm.indices) {
            println(masSm[i].contentToString())
        }
    }






}