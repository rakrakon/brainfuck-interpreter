class Parser {
    companion object {
        fun parseAndValidate(content: String): String {
            val validChars = "<>+-[].,"
            val filteredChars = StringBuilder(content.length)
            val loopStack = mutableListOf<Int>()

            for (charIndex in content.indices) {
                val char = content[charIndex]
                if (char in validChars) {
                    filteredChars.append(char)
                    if (char == '[') {
                        loopStack.add(charIndex)
                    } else if (char == ']') {
                        if (loopStack.isEmpty()) {
                            throw IllegalStateException("Unmatched ']' at index $charIndex")
                        }
                        loopStack.removeAt(loopStack.size - 1)
                    }
                }
            }

            if (loopStack.isNotEmpty()) {
                throw IllegalStateException("Unmatched '[' at index ${loopStack[0]}")
            }

            return filteredChars.toString()
        }
    }
}