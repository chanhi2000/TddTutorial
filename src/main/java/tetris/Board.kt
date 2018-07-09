package tetris

data class Board(private val rows: Int,
                 private val columns: Int,
                 private var fallingBlock: Block? = null,
                 private var fallingBlockRow: Int = 0,
                 private var fallingBlockCol: Int = 1) {
    private var stationary: Array<Array<Char>> = emptyBoard(rows, columns)

    override fun toString(): String {
        var s = ""
//        var fb = fallingBlock ?: return s
        (0 until rows).forEach { r:Int ->
            (0 until columns).forEach { c:Int ->
                s += blockAt(r,c)
            }
            s += "\n"
        }
        return s
    }

    fun hasFalling(): Boolean = fallingBlock != null

    private fun blockAt(row:Int, col:Int): Char = if (hasFallingAt(row, col)) fallingBlock?.color ?: EMPTY else stationary[row][col]
    private fun hasFallingAt(row: Int, col: Int) = hasFalling() && row == fallingBlockRow && col == fallingBlockCol

    fun drop(block: Block) {
        if (hasFalling()) {
            throw IllegalStateException("a block is already falling")
        }
        fallingBlock = block
        fallingBlockRow = 0
        fallingBlockCol = 1
    }

    fun tick() {
        if (fallingHitsAnotherBlock() || fallingHitsFloor())
            stopFalling()
        else
            fallBy(1)
    }

    private fun fallingHitsFloor():Boolean =
        fallingBlockRow == rows - 1

    private fun fallingHitsAnotherBlock():Boolean =
            fallingBlockRow + 1 < rows && stationary[fallingBlockRow+1][fallingBlockCol] != EMPTY

    private fun stopFalling() {
        stationary[fallingBlockRow][fallingBlockCol] = fallingBlock!!.color
        fallingBlock = null
    }

    private fun fallBy(n:Int=1) {
        fallingBlockRow += n
    }

    private fun emptyBoard(rows: Int, cols: Int): Array<Array<Char>> =
        Array(rows, {
            Array(cols, {  EMPTY  })
        })

    companion object {
        private const val EMPTY = '.'
    }
}