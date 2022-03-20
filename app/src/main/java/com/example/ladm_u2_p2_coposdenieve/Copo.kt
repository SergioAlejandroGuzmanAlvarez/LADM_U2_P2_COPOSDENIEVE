package com.example.ladm_u2_p2_coposdenieve

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.random.Random

class Copo (puntero:Lienzo){
    var posX=0f //Posicion en X
    var posY=0f //Posicion en Y
    var IncrementoX=0f // Movimiento en X
    var IncrementoY=0f // Movimiento en Y
    val puntero = puntero // Guardamos el valor del puntero del  lienzo
    val copoBase = BitmapFactory.decodeResource(puntero.resources, R.drawable.copo)
    init {
        posX=rand(1000)
        posY=rand(1900)
        IncrementoX=rand(6)+2
        IncrementoY=rand(6)+2
    }//Iniciamos nuestro constructor
    private fun rand(hasta:Int):Float{
        return Random.nextInt(hasta).toFloat()
    }//Función random

    fun moverCopos(){
        posX+=IncrementoX //Incrementamos en X la posicion
        if(posX>puntero.width-30){
            posX=0f
        }
    }
    fun pintarCopo(c: Canvas){
        var p = Paint()
        c.drawBitmap(copoBase, posX, posY, p)
    }
}