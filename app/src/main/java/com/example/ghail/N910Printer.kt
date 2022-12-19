package com.nukkadshops.gmrtransportsystem.N910Printer

import android.content.Context
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import com.example.ghail.*
import com.pnsol.sdk.interfaces.DeviceType
import com.pnsol.sdk.interfaces.PaymentTransactionConstants
import com.pnsol.sdk.payment.PaymentInitialization

class N910Printer(val context: Context) : BasePrinter {

    private val totalStringBuffer: StringBuilder = StringBuilder()

    private fun getHandler(context: Context): Handler {
        if (Looper.myLooper() == null) {
            Looper.prepare()
        }
        return object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (msg.what == PaymentTransactionConstants.SUCCESS) {
                    Toast.makeText(context, msg.obj.toString(), Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    override fun printBiggerText(text: String, allignment: String) {
        val stringBuffer = StringBuffer()
        stringBuffer.appendFontStyle(PrintFontSize.LARGE, 5)
        stringBuffer.appendText(text, allignment)
        printText(stringBuffer)
    }


    /*Below two methods are to wrap the text
         * */
    override fun printBiggerText(storeName: String?, size: Int, isSmallCase: Boolean) {
        val stringBuffer = StringBuffer()
        stringBuffer.appendFontStyle(PrintFontSize.LARGE, 5)
        stringBuffer.appendSpace(10)
        stringBuffer.appendText(storeName!!, PrintTextAlignment.CENTER)
        printText(stringBuffer)

    }

    override fun printSmallerText(txt: String?, size: Int, isSmallCase: Boolean) {
        val stringBuffer = StringBuffer()
        stringBuffer.appendFontStyle(PrintFontSize.NORMAL, 5)
        stringBuffer.appendSpace(10)
        stringBuffer.appendText(txt!!, PrintTextAlignment.CENTER)
        printText(stringBuffer)
    }


    override fun printText(alignment: StringBuffer) {
        totalStringBuffer.append(alignment)
    }


    fun printEmptyLinesAtBottom(isClear: Boolean) {
        if (isClear) clearBuffer()
        val stringBuffer = StringBuffer()
        stringBuffer.appendFontStyle(PrintFontSize.NORMAL, 5)
        stringBuffer.appendSpace(20)
        stringBuffer.appendText(" ", PrintTextAlignment.CENTER)
        printText(stringBuffer)
        print()
    }

    override fun printEmptyLine() {
        val stringBuffer = StringBuffer()
        stringBuffer.appendFontStyle(PrintFontSize.NORMAL, 5)
        stringBuffer.appendSpace(20)
        stringBuffer.appendText(" ", PrintTextAlignment.CENTER)
        printText(stringBuffer)
    }


    fun clearBuffer() {
        totalStringBuffer.clear()
    }

    override fun printImage(context: Context, scaledBitmap: Bitmap, alignment: String) {
        val initialization = PaymentInitialization(context)

        initialization.printImage(
            getHandler(context),
            DeviceType.N910,
            scaledBitmap,
            PrintTextAlignment.CENTER
        )
    }


    override fun print(): ArrayList<ByteArray>? {
        if (context != null) {
            val initialization = PaymentInitialization(context)
            Log.d("JCKSHKJ", totalStringBuffer.toString())
            initialization.printText(getHandler(context), DeviceType.N910, totalStringBuffer)
        }
        return null
    }
}