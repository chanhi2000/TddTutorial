package tetris

data class Board(val rows: Int, val columns: Int) {
    override fun toString(): String {
        var s = ""
        (0 until rows).forEach {
            (0 until columns).forEach {  s += "."  }
            s += "\n"
        }
        return s
    }
}