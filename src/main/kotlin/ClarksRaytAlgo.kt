import java.util.Objects

class ClarksRaytAlgo(matrix :Array<Array<Double>>,list: List<Double>) {

    val matrix = matrix
    var rowIndex = -1
    var columnIndex =-1
    var rowIndexForRout = -1
    var columnIndexForRout =-1
    var routList= mutableListOf<Int>()
    val listWeight:MutableList<Double> = list.toMutableList()

    init {

    }

    fun findMaxValueInMatrixKmWin():Double{
        var maxValue:Double=0.0
        for (i in 0 until matrix.size){
            for(j in 0 until matrix[i].size){
                if(matrix[i][j]>maxValue){
                    maxValue = matrix[i][j]
                    rowIndex = i
                    columnIndex = j
                }
            }
        }
        routList.add(rowIndex)
        routList.add(columnIndex)
        return maxValue
    }

    fun findMaxValueInRowOrColumn(max:Double){
        var maxValueRow:Double=0.0
        var maxValueColumn:Double=0.0
        for(i in 0 until matrix.size){
            if(matrix[i][columnIndex]>maxValueRow && matrix[i][columnIndex]!=max){
                maxValueRow =matrix[i][columnIndex]
                rowIndexForRout =i
            }
           if(matrix[rowIndex][i]>maxValueColumn && matrix[rowIndex][i]!=max){
               maxValueColumn = matrix[rowIndex][i]
               columnIndexForRout=i
           }
        }
        println(rowIndex)
        println(columnIndex)
        addRoutNewPoint(maxValueRow,maxValueColumn)
        println("maxRow=$maxValueRow maxColumn=$maxValueColumn")
    }

    fun addRoutNewPoint(valueRow:Double,valueColumn:Double){
        if(valueRow>valueColumn){
            putNull(routList.last())
            routList.add(columnIndexForRout)
        }
        else {
            putNull(routList.first())
            routList.add(0,rowIndexForRout)
        }
    }


    fun putNull(index:Int){
        for(i in 0 until matrix.size){
            matrix[i][index]=0.0
            matrix[index][i]=0.0
        }
        listWeight.set(index,0.0)
    }

}