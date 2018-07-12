package tetris

class Piece : Grid {
    private var blocks: Array<Array<Char>>
    constructor(shape: String) {
        val rows = shape.split("\n")
        blocks = Array(rows.size-1, {
            Array(rows.size, {  Grid.EMPTY  })
        })
        (0 until rows.size-1).forEach { r: Int ->
            blocks[r] = rows[r].map { it }.toTypedArray()
        }
    }

    constructor(blocks: Array<Array<Char>>) {
        this.blocks = blocks
    }

    override fun rows(): Int = blocks.size
    override fun cols(): Int = blocks[0].size
    override fun blockAt(row: Int, col: Int): Char = blocks[row][col]
    override fun toString(): String = Grid.getString(this)

    /**
     * 0,0 -> 0,2
     * 0,1 -> 1,2
     * 0,2 -> 2,2
     * 1,0 -> 0,1
     * 1,1 -> 1,1
     * 1,2 -> 2,1
     */
    fun rotateRight(): Piece {
        val rotated = Array(rows(), {
            Array(cols(), {  Grid.EMPTY  })
        })
        (0 until rows()).forEach { r:Int ->
            (0 until blocks[r].size).forEach { c:Int ->
                rotated[c][rows()-1-r] = blockAt(r,c)
            }
        }
        return Piece(rotated)
    }

    fun rotateLeft(): Piece {
        return rotateRight().rotateRight().rotateRight()
    }
}