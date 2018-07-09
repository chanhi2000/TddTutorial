package tetris

import net.orfjackal.nestedjunit.NestedJUnit
import org.junit.runner.RunWith
import org.junit.*

@Ignore("contains no test")
@RunWith(NestedJUnit::class)
class RotatingPiecesOfBlocksTest : Assert() {
    /**
     * Step 2: Stepping stone for rotation algorithms
     * - Remove the @Ignore annotation from this class
     * - See README for motivation
     * - Next step: RotatingTetrominoesTest
     */

    /*
    private Piece piece;
    public class A_piece_of_3x3_blocks {
        @Before
        public void createPiece() {
            piece = new Piece("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n");
        }
        @Test
        public void consists_of_many_blocks() {
            assertEquals("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n", piece.toString());
        }
//        @Test
//        public void can_be_rotated_right() {
//            piece = piece.rotateRight();
//            assertEquals("" +
//                    "...\n" +
//                    ".XX\n" +
//                    "...\n", piece.toString());
//        }
//        @Test
//        public void can_be_rotated_left() {
//            piece = piece.rotateLeft();
//            assertEquals("" +
//                    "...\n" +
//                    "XX.\n" +
//                    "...\n", piece.toString());
//        }
    }
    */
    /*
    public class A_piece_of_5x5_blocks {
        @Before
        public void createPiece() {
            piece = new Piece("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n");
        }
        @Test
        public void consists_of_many_blocks() {
            assertEquals("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n", piece.toString());
        }
//        @Test
//        public void can_be_rotated_right() {
//            piece = piece.rotateRight();
//            assertEquals("" +
//                    ".....\n" +
//                    ".....\n" +
//                    "..XXX\n" +
//                    "...XX\n" +
//                    "....X\n", piece.toString());
//        }
//        @Test
//        public void can_be_rotated_left() {
//            piece = piece.rotateLeft();
//            assertEquals("" +
//                    "X....\n" +
//                    "XX...\n" +
//                    "XXX..\n" +
//                    ".....\n" +
//                    ".....\n", piece.toString());
//        }
    */
}