package tetris



class Tetromino {
    private var currentOrientation:Int
    private var orientations: Array<Piece?>
    constructor (currentOrientation: Int, orientations: Array<Piece?>) {
        this.currentOrientation = (orientations.size + currentOrientation) % orientations.size
        this.orientations = orientations
    }

    constructor(shape: String, numOrientation: Int) : this(0, arrayOfNulls<Piece>(numOrientation)) {
        var p = Piece(shape)
        (0 until numOrientation).forEach { i:Int ->
            orientations[i] = p
            p = p.rotateRight()
        }
    }

    fun rotateRight(): Tetromino {
        return Tetromino(currentOrientation+1, orientations)
    }

    fun rotateLeft(): Tetromino {
        return Tetromino(currentOrientation-1, orientations)
    }

    override fun toString(): String = orientations[currentOrientation].toString()

    companion object {
        val T_SHAPE = Tetromino(".T.\nTTT\n...\n", 4)
        val I_SHAPE = Tetromino(".....\n.....\nIIII.\n.....\n.....\n", 2)
        val O_SHAPE = Tetromino(".OO\n.OO\n...\n", 1)
        val L_SHAPE = Tetromino("...\nLLL\nL..\n", 4)
        val J_SHAPE = Tetromino("...\nJJJ\n..J\n", 4)
        val S_SHAPE = Tetromino("...\n.SS\nSS.\n", 2)
        val Z_SHAPE = Tetromino("...\nZZ.\n.ZZ\n", 2)
    }
}