package tetris

interface Grid {
    fun rows(): Int
    fun cols(): Int
    fun blockAt(row:Int, col:Int): Char

    companion object {
        const val EMPTY = '.'

        fun getString(grid: Grid) : String {
            val s = StringBuilder()
            (0 until grid.rows()).forEach { r:Int ->
                (0 until grid.cols()).forEach { c:Int ->
                    s.append(  grid.blockAt(r,c)  )
                }
                s.append("\n")
            }
            return s.toString()
        }

        fun make2DGrid(grid: Grid) : Array<Array<Char>> {
            return Array(grid.rows(), {
                Array(grid.cols(), {  Grid.EMPTY  })
            })
        }
    }
}