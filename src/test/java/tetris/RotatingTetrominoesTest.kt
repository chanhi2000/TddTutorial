package tetris

import net.orfjackal.nestedjunit.NestedJUnit
import org.junit.runner.RunWith
import org.junit.*

@Ignore("contains no test")
@RunWith(NestedJUnit::class)
class RotatingTetrominoesTest : Assert() {
    /**
     * Step 3: The actual rotation algorithms
     * - Remove the @Ignore annotation from this class
     * - See README for how "Tetromino" is different from "Piece"
     * - Next step: FallingPiecesTest
     */

    private lateinit var shape: Tetromino

    inner class AllShapeInstances {
        @Before
        fun createAnyShape() {
            shape = Tetromino.T_SHAPE
        }

        @Test
        fun areImmutable() {
            val original = shape.toString()
            shape.rotateRight()
            assertEquals(original, shape.toString())
            shape.rotateLeft()
            assertEquals(original, shape.toString())
        }
    }

    inner class TheShapeWith4Orientations {
        @Before
        fun createTShape() {
            shape = Tetromino.T_SHAPE
        }

        @Test
        fun shouldShape() {
            assertEquals("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n", shape.toString())
        }

        @Test
        fun canBeRotatedRight3Times() {
            shape = shape.rotateRight()
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString())
            shape = shape.rotateRight()
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString())
            shape = shape.rotateRight()
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString())
        }

        @Test
        fun canBeRotatedLeft3Times() {
            shape = shape.rotateLeft()
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString())
            shape = shape.rotateLeft()
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString())
            shape = shape.rotateLeft()
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString())
        }

        @Test
        fun rotatingIt4Times_willGoBackToTheOriginalShape() {
            val originalShape = shape.toString()
            shape = shape.rotateRight().rotateRight().rotateRight().rotateRight()
            assertEquals(originalShape, shape.toString())
            shape = shape.rotateLeft().rotateLeft().rotateLeft().rotateLeft()
            assertEquals(originalShape, shape.toString())
        }
    }

    inner class TheShapeWith2Orientations {
        @Before
        fun createIShape() {
            shape = Tetromino.I_SHAPE
        }

        @Test
        fun shouldShape() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    "IIII.\n" +
                    ".....\n" +
                    ".....\n", shape.toString())
        }

        @Test
        fun canBeRotatedRightOnce() {
            shape = shape.rotateRight()
            assertEquals("" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    ".....\n", shape.toString())
        }

        @Test
        fun rotatingItTwice_willGetBackToTheOriginalShape() {
            val originalShape = shape.toString()
            shape = shape.rotateRight().rotateRight()
            assertEquals(originalShape, shape.toString())
            shape = shape.rotateLeft().rotateLeft()
            assertEquals(originalShape, shape.toString())
        }
    }

    inner class TheShapeWith1Orientations {
        @Before
        fun createOShape() {
            shape = Tetromino.O_SHAPE
        }

        @Test
        fun shouldShape() {
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString())
        }

        @Test
        fun cannotBeRotatedRight() {
            shape = shape.rotateRight()
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString())
        }
        @Test
        fun cannotBeRotatedLeft() {
            shape = shape.rotateLeft()
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString())
        }
    }
}