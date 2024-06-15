import java.io.File

class Main {
    fun main(args: Array<String>) {
        if (args.size != 1) {
            println("Usage: Main <filename>")
            return
        }

        val fileName = args[0]
        val file = File(fileName)

        if (!file.exists()) {
            println("File not found: $fileName")
            return
        }

        val content: String = file.readText()

        val parsedContent: String = Parser.parseAndValidate(content)
        Interpreter.interpret(parsedContent)
    }
}