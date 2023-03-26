import java.util.Objects

class ClarksRaytAlgo(matrix :Array<Array<Double>>,list: List<Double>) {

    var checkLimit=true
    var curWeight=0.0
    val limit = 1500
    val matrix = matrix
    var maxValueKmWin=0.0
    var rowIndexForRout = -1
    var columnIndexForRout =-1
    var routList= mutableListOf<Int>()                  //лист маршрута
    val listWeight:MutableList<Double> = list.toMutableList()

    init {
        /*findMaxValueInMatrixKmWin()
        while(checkLimit){
            findMaxValueInRowOrColumn()
        }
        readMatrix(matrix)
        println("???????")
        findMaxValueInMatrixKmWin()
        while(checkLimit){
            findMaxValueInRowOrColumn()
        }
        readMatrix(matrix)
        findMaxValueInMatrixKmWin()
        while(checkLimit){
            findMaxValueInRowOrColumn()
        }
        readMatrix(matrix)
        //findMaxValueInRowOrColumn()
        //algo()*/
        algo()
    }

    fun findMaxValueInMatrixKmWin(){
        checkLimit=true
        for (i in 0 until matrix.size){
            for(j in 0 until matrix[i].size){
                if(matrix[i][j]>maxValueKmWin){
                    routList.clear()
                    maxValueKmWin = matrix[i][j]
                    routList.add(i)
                    routList.add(j)
                }
            }
        }
        println("rlist = $routList")
        curWeight+=listWeight.get(routList.first())+listWeight.get(routList.last())
        println("cWeight = $curWeight")
    }

    /*fun findMaxVal(){
        maxValueKmWin=0.0
        for(i in 0 until matrix.size){
            if(matrix[i][routList.last()]>maxValueKmWin){
                maxValueKmWin =matrix[i][routList.last()]
            }
            if(matrix[routList.first()][i]>maxValueKmWin){
                maxValueKmWin = matrix[routList.first()][i]
            }
        }
    }*/



    fun findMaxValueInRowOrColumn(){

        var maxValueRow:Double=0.0
        var maxValueColumn:Double=0.0
        for(i in 0 until matrix.size){
            if(matrix[i][routList.last()]>maxValueRow && matrix[i][routList.last()]!=maxValueKmWin && matrix[i][routList.last()]!=matrix[routList.first()][routList.last()]){
                maxValueRow =matrix[i][routList.last()]
                rowIndexForRout =i
            }
            if(matrix[routList.first()][i]>maxValueColumn && matrix[routList.first()][i]!=maxValueKmWin && matrix[routList.first()][i]!=matrix[routList.first()][routList.last()]){
                maxValueColumn = matrix[routList.first()][i]
                columnIndexForRout=i
            }
        }
        println("cWeight = $curWeight")
        println("maxRow=$maxValueRow maxColumn=$maxValueColumn")

        addRoutNewPoint(maxValueRow,maxValueColumn)
    }

    fun checkLimitedWeight(valueRow:Double,valueColumn:Double):Boolean{
        var checkCurWeight =curWeight
        if(valueRow>valueColumn){
            checkCurWeight+=listWeight.get(rowIndexForRout)
        }else{
            checkCurWeight+=listWeight.get(columnIndexForRout)
        }
        if(checkCurWeight>limit) return false
        else return true
    }


    fun addRoutNewPoint(valueRow:Double,valueColumn:Double){
        when(checkLimitedWeight(valueRow, valueColumn)){
            true -> {
                if(valueRow>valueColumn){

                    putNull(routList.last())
                    routList.add(rowIndexForRout)
                    curWeight+=listWeight.get(routList.last())
                }
                else {
                    putNull(routList.first())
                    routList.add(0,columnIndexForRout)
                    curWeight+=listWeight.get(routList.first())
                }
                //findMaxVal()
            }
            false-> {
                checkLimit=false
                rowIndexForRout = -1
                columnIndexForRout =-1
                maxValueKmWin=0.0
                curWeight=0.0
                println(routList)
                nullMatrix(routList.first())
                nullMatrix(routList.last())
                listWeight.set(routList.first(),0.0)
                listWeight.set(routList.last(),0.0)
                routList.clear()
                println("l = $listWeight")
            }
        }

    }

    fun algo(){

        while (!checkListWeight()) {
            var quantity=0
            listWeight.forEach { if(it==0.0){
                quantity++
            }
            }
            if(quantity==2){
                case2()
            }
            if(quantity==11){
                case1()
            }
            else {
                findMaxValueInMatrixKmWin()
                while (checkLimit) {
                    findMaxValueInRowOrColumn()

                }
            }

        }
    }

    private fun case2() {
        print("Маршрут: ")
        var result= mutableListOf<Int>()
        listWeight.forEachIndexed() { index, d ->
            if(d!=0.0){
                result.add(index)
                listWeight.set(index,0.0)
            }
        }
        println(result)
    }

    fun case1(){
        print("Маршрут: ")
        var result= mutableListOf<Int>()
        listWeight.forEachIndexed() { index, d ->
            if(d!=0.0){
                result.add(index)
                listWeight.set(index,0.0)
            }
        }
        println(result)
    }


    fun putNull(index:Int){
        for(i in 0 until matrix.size){
            matrix[i][index]=0.0
            matrix[index][i]=0.0
        }
        println(routList)
        listWeight.set(index,0.0)
    }


    fun checkListWeight():Boolean = listWeight.all { 0.0==it }

    fun readMatrix(matrix:Array<Array<Double>>){
        for (i in matrix.indices) {
            println(matrix[i].contentToString())
        }
    }


    fun nullMatrix(ind:Int){
        for(i in 0 until matrix.size){
            matrix[i][ind]=0.0
            matrix[ind][i]=0.0
        }
    }
}