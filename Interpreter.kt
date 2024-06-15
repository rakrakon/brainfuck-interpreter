class Interpreter {
    fun interpret(input: String) {
        val memory = ByteArray(30000)
        var pointer = 0

        var codePointer = 0

        while (codePointer < input.length) {
            when (input[codePointer]) {
                '>' -> pointer++
                '<' -> pointer--
                '+' -> memory[pointer]++
                '-' -> memory[pointer]--
                ',' -> println(memory[pointer].toInt().toChar())
                '.' -> memory[pointer] = readln()[0].code.toByte()
                '[' -> {
                    if (memory[pointer] == 0.toByte()) {
                        var loop = 1
                        while (loop > 0) {
                            codePointer++
                            if (input[codePointer] == '[') loop++
                            if (input[codePointer] == ']') loop--
                        }
                    }
                }
                ']' -> {
                    if (memory[pointer].toInt() != 0) {
                        var loop = 1
                        while (loop > 0) {
                            codePointer--
                            if (input[codePointer] == '[') loop--
                            if (input[codePointer] == ']') loop++
                        }
                    }
                }
            }
            codePointer++
        }
     }
}