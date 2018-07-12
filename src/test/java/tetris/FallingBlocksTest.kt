package tetris

import net.orfjackal.nestedjunit.NestedJUnit
import org.junit.runner.RunWith
import org.junit.*

@RunWith(NestedJUnit::class)
class FallingBlocksTest : Assert() {
    /**
     * Step 1: Starting small
     * - See the README for motivation
     * - Next step: RotatingPiecesOfBlocksTest
     */
//    private lateinit var board:Board
    private val board = Board(3, 3)

    inner class NewBoard {
        @Test
        fun isEmpty() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    "...\n", board.toString())
        }

        @Test
        fun hasNoFallingBlocks() {
            assertFalse(board.hasFalling())
        }
    }

    inner class WhenABlockIsDropped {
        @Before
        fun dropBlock() {
            board.drop(Block( 'X'))
        }

        @Test
        fun theBlockIsFalling() {
            assertTrue(board.hasFalling())
        }

        @Test
        fun itStartsFromTheTopMiddle() {
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board.toString())
        }

        @Test
        fun itMovesDownOneRowPerTick() {
            board.tick();
            assertEquals("" +
                    "...\n" +
                    ".X.\n" +
                    "...\n", board.toString());
        }

        @Test
        fun atMostOneBlockMayBeFallingAtATime() {
            val t = AssertUtils.throwException(Runnable {
                board.drop(Block('Y'))
            })
            assertTrue(t is IllegalStateException)
            assertTrue(t?.message!!.contains("already falling"))
            assertEquals("" +

                    ".X.\n" +
                    "...\n" +
                    "...\n", board.toString());
        }
    }

    inner class WhenABlockReachesTheBottom {
        @Before
        fun fallToLastRow() {
            board.drop(Block('X'))
            board.tick()
            board.tick()
        }

        @Test
        fun itIsStillFallingOnTheLastRow() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString())
            assertTrue("the player should still be able to move the block", board.hasFalling())
        }

        @Test
        fun itStopsWhenItHitsTheBottom() {
            board.tick()
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString())
            assertFalse("the block should stop moving", board.hasFalling())
        }
    }

    inner class WhenABlockLandsOnAnotherBlock {
        @Before
        fun landOnAnother() {
            board.drop(Block('X'))
            board.tick()
            board.tick()
            board.tick()
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString())
            assertFalse(board.hasFalling())
            board.drop(Block('Y'))
            board.tick()
        }

        @Test
        fun itIsStillFallingRightAboveTheOtherBlock() {
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString())
            assertTrue("the player should still be able to avoid landing on the other block", board.hasFalling())
        }

        @Test
        fun itStopsWhenItHitsTheOtherBlock() {
            board.tick()
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString())
            assertFalse("the block should stop moving when it lands on the other block", board.hasFalling())
        }
    }
}