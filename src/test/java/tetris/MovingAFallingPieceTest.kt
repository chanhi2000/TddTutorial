package tetris

import net.orfjackal.nestedjunit.NestedJUnit
import org.junit.runner.RunWith
import org.junit.*

@Ignore("contains no test")
@RunWith(NestedJUnit::class)
class MovingAFallingPieceTest : Assert() {
    /**
     * Step 5: It's your turn now
     * - Remove the @Ignore annotation from this class
     * - The test names have been provided, you just need to fill in the test body
     * - Next step: RotatingAFallingPieceTest
     */

    // TODO: a falling piece can be moved left
    // TODO: a falling piece can be moved right
    // TODO: a falling piece can be moved down
    // TODO: it will not move left over the board
    // TODO: it will not move right over the board
    // TODO: it will not move down over the board (will stop falling)
    // TODO: it cannot be moved left if another piece is in the way
    // TODO: it cannot be moved right if another piece is in the way
    // TODO: it cannot be moved down if another piece is in the way (will stop falling)
    // P.S. Take into consideration, that part of the piece's area may be empty cells.
    // Only non-empty cells should take part in the collision checks.
}