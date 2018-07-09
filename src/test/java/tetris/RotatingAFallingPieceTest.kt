package tetris

import net.orfjackal.nestedjunit.NestedJUnit
import org.junit.runner.RunWith
import org.junit.*

@Ignore("contains no test")
@RunWith(NestedJUnit::class)
class RotatingAFallingPieceTest : Assert() {
    /**
     * Step 6: Training wheels off
     * - Remove the @Ignore annotation from this class
     * - You're now responsible for covering all corner cases
     * - Next step: see the README for details
     */

    // TODO: a falling piece can be rotated clockwise
    // TODO: a falling piece can be rotated counter-clockwise
    // TODO: it cannot be rotated when there is no room to rotate (left wall, right wall, other pieces...)
    // TODO: when piece is up against a wall (or piece) and it is rotated (no room to rotate), move it away from the wall ("wallkick")
    // See: http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick1.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick2.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick3.png
}