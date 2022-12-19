package com.example.ghail


fun StringBuffer.appendFontStyle(fontSize: String, grayScale: Int = 5): StringBuffer {
    this.append("!asc $fontSize\n !gray $grayScale\n")
    this.append("!yspace 10\n")
    return this
}


fun StringBuffer.appendSpace(space: Int): StringBuffer {
    this.append("!yspace $space\n")
    return this
}

fun StringBuffer.appendText(text: String, alignment: String = "l"): StringBuffer {
    text.split("\n").forEach { item_ ->
        if (item_ == "*line") {
            this.appendHorizontalLine()
        } else if (item_.isNotEmpty()) {
            this.append("*text $alignment $item_\n")
        }
    }

    return this
}

fun StringBuffer.appendHorizontalLine(): StringBuffer {
    this.append("*line \n")
    return this
}


