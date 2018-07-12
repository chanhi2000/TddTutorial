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

    private lateinit var piece:Piece

    inner class APieceOf3x3Blocks {
        @Before
        fun createPiece() {
            piece = Piece(
                    ".X.\n" +
                    ".X.\n" +
                    "...\n")
        }

        @Test
        fun consistsOfManyBlocks() {
            assertEquals( ".X.\n" +
                    ".X.\n" +
                    "...\n", piece.toString())
        }

        @Test
        fun canBeRotatedRight() {
            piece = piece.rotateRight()
            assertEquals( "...\n" +
                    ".XX\n" +
                    "...\n", piece.toString())
        }

        @Test
        fun canbeRotatedLeft() {
            piece = piece.rotateLeft()
            assertEquals(
                    "...\n" +
                    "XX.\n" +
                    "...\n", piece.toString())
        }
    }

    inner class APieceOf5x5Blocks {
        @Before
        fun createPiece() {
            piece = Piece("..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n")
        }

        @Test
        fun consistsOfManyBlocks() {
            assertEquals("..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n", piece.toString())
        }

        @Test
        fun canBeRotatedRight() {
            piece = piece.rotateRight()
            assertEquals(".....\n" +
                    ".....\n" +
                    "..XXX\n" +
                    "...XX\n" +
                    "....X\n", piece.toString())
        }

        @Test
        fun canBeRotatedLeft() {
            piece = piece.rotateLeft()
            assertEquals("" +
                    "X....\n" +
                    "XX...\n" +
                    "XXX..\n" +
                    ".....\n" +
                    ".....\n", piece.toString())
        }
    }
}