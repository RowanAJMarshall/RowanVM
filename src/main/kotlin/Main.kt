import java.util.*

fun main(args: Array<String>) {

}

typealias Memory = Stack<DataType>

class Program(val name: String, private val functions: List<Function>) {

    fun start(main: String = "main"): Memory {
        val memory = Memory()
        for (f in functions) {
            if (f.name == main) {
                f.call(memory)
                break
            }
        }
        return memory
    }

}

class Function(val name: String, private val instructions: List<Instruction>) {

    fun call(memory: Memory): Memory {
        for (i in instructions) {
            i.execute(memory)
        }
        return memory
    }

}

class Instruction(private val opcode: Opcode, private val args: List<DataType>) {

    fun execute(memory: Memory) {
        when (opcode) {
            Opcode.INT_ADD -> {
                val first = memory.pop() as DataType.IntType
                val second = memory.pop() as DataType.IntType
                memory.push(
                    DataType.IntType(first.value + second.value)
                )
            }
            Opcode.PUSH -> {
                memory.push(args[0])
            }
            Opcode.INT_MINUS -> {
                val first = memory.pop() as DataType.IntType
                val second = memory.pop() as DataType.IntType
                memory.push(
                    DataType.IntType(first.value - second.value)
                )
            }
        }
    }
}

enum class Opcode {
    PUSH,
    INT_ADD,
    INT_MINUS
}

open class DataType {
    class StrType(val value: String) : DataType()
    class IntType(val value: Int) : DataType()
}