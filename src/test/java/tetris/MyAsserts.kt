package tetris

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.instanceOf

object MyAsserts {
    fun assertThrows(expectedException: Class<*>,
                     expectedMessage: String,
                     command: Command) {
        try {
            command.run()
        } catch (t: Throwable) {
            assertThat("thrown exception", t, instanceOf(expectedException))
            assertThat("exception message", t.message, containsString(expectedMessage))
            return
        }
        throw AssertionError("Expected to throw " + expectedException.name + ", but did not throw anything")
    }

    interface Command {
        @Throws(Throwable::class)
        fun run()
    }
}