import org.junit.Assert.assertTrue
import org.junit.Test

class MainTest {

    @Test
    fun addAndPushTest() {
        val result = Program(
            "Add 5 and 10 to make 15", listOf(
                Function(
                    "main", listOf(
                        Instruction(Opcode.PUSH, listOf(DataType.IntType(5))),
                        Instruction(Opcode.PUSH, listOf(DataType.IntType(10))),
                        Instruction(Opcode.INT_ADD, listOf())
                    )
                )
            )
        ).start()

        assertTrue("result has more than one item", result.size == 1)
        assertTrue(
            "result is not 15",
            (result.pop() as DataType.IntType).value == 15
        )
    }

}