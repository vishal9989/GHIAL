package com.example.ghail

internal interface PrintFontSize {
    companion object {
        //    l is to print large text(Accept 24 characters print in a row)
        //    s for small text(Accept 32 characters in a row)
        //    n for normal text(Accept 48 characters in a row)
        const val LARGE = "l"
        const val SMALL = "s"
        const val NORMAL = "n"
    }
}

internal interface PrintTextAlignment {
    companion object {

        const val LEFT = "l"
        const val CENTER = "c"
        const val RIGHT = "r"
    }
}



