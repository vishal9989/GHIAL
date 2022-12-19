package com.nukkadshops.gmrtransportsystem.N910Printer

import android.content.Context
import android.graphics.Bitmap

class GMRTransactionTemplate(context: Context) {

    val printer = N910Printer(context)

    fun printLineAtBottom(isClear: Boolean = false) {
        printer.printEmptyLinesAtBottom(isClear)
    }

    fun printImage(context: Context, image: Bitmap, alignment: String) {
        printer.printImage(context, image, alignment)
    }

    fun printComplete(): ArrayList<ByteArray>? {
        return printer.print()
    }
}