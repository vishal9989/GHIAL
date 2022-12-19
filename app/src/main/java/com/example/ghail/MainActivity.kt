package com.example.ghail

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nukkadshops.gmrtransportsystem.N910Printer.GMRTransactionTemplate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var gmrDetailsPrinting: GMRTransactionTemplate
    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
    }

    fun print(view: View) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                if (context != null) {
                    gmrDetailsPrinting = GMRTransactionTemplate(context!!)
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.aviserv)
                    gmrDetailsPrinting.printImage(context!!, bitmap, PrintTextAlignment.CENTER)
                    gmrDetailsPrinting.printComplete()
                    gmrDetailsPrinting.printLineAtBottom(true)
                    gmrDetailsPrinting.printLineAtBottom(true)
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}