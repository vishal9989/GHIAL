package com.example.ghail

import android.content.Context
import android.graphics.Bitmap

interface BasePrinter {
    fun printBiggerText(text: String, allignment: String = PrintTextAlignment.CENTER)
    fun printBiggerText(storeName: String?, size: Int, isSmallCase: Boolean)
    fun printSmallerText(txt: String?, size: Int, isSmallCase: Boolean)
    fun printText(alignment: StringBuffer)
    fun printEmptyLine()
    fun printImage(context: Context, scaledBitmap: Bitmap, alignment: String)
    fun print(): ArrayList<ByteArray>?


}