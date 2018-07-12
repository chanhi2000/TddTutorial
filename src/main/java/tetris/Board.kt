package tetris


data class Board(private val rows: Int,
                 private val columns: Int,
                 private var fallingBlock: Block? = null,
                 private var fallingBlockRow: Int = 0,
                 private var fallingBlockCol: Int = 1) : Grid {
    private var stationary: Array<Array<Char>> = Grid.make2DGrid(this)

    override fun rows(): Int = rows
    override fun cols(): Int = columns
    override fun blockAt(row:Int, col:Int): Char = if (hasFallingAt(row, col)) fallingBlock?.color ?: Grid.EMPTY else stationary[row][col]

    override fun toString(): String = Grid.getString(this)
    fun hasFalling(): Boolean = fallingBlock != null
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
            fallingBlockRow + 1 < rows && stationary[fallingBlockRow+1][fallingBlockCol] != Grid.EMPTY

    private fun stopFalling() {
        stationary[fallingBlockRow][fallingBlockCol] = fallingBlock!!.color
        fallingBlock = null
    }

    private fun fallBy(n:Int=1) {
        fallingBlockRow += n
    }
}