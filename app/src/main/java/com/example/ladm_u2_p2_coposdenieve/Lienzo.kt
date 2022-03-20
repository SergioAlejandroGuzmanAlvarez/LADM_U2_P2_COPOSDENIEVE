package com.example.ladm_u2_p2_coposdenieve
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo (p:MainActivity) : View(p) {
    val VectorCopos= Array<Copo>(15,{ Copo(this) })
    val VectorCopos1= Array<Copo>(70,{ Copo(this) })
    val VectorCopos2= Array<Copo>(120,{ Copo(this) })
    var VectorColores = arrayOf( Color.rgb(236,181,79),
        Color.rgb(61,76,91), Color.BLACK)
    var auxiliar=0; // Variable auxiliar para los vectores
    val este = p
    var fondo = Color.WHITE
    val corrutinaCopos = GlobalScope.launch {
        while(true){
            este.runOnUiThread{
                invalidate()
            }
            delay(100L)
        }
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        //Dibujado de canvas
        c.drawColor(fondo)
        //Arbol izquierda en medio
        // Casita con la chimenea
        p.color = Color.rgb(252,154,238)
        c.drawRect(400f,1600f,1000f,400f,p)
        p.color = Color.rgb(99,16,16)
        c.drawRect(300f,1600f,500f,1200f,p)
        //Puerta
        p.color = Color.rgb(110,82,71)
        c.drawRect(600f,1250f,1000f,1500f,p)
        //Ventana
        p.color = Color.rgb(131,216,192)
        c.drawRect(800f,500f,500f,1000f,p)
        //Nubes chimenea
        p.color = Color.rgb(129,129,129)
        c.drawOval(200f, 1520f, 280f, 1250f,p)
        c.drawOval(150f, 1220f, 230f, 1000f,p)
        c.drawOval(100f, 900f, 200f, 700f,p)
        //Arbol derecha
        p.color = Color.rgb(30,132,73) //Verde
        //Arbol de la derecha - Arbustos
        c.drawOval(800f, 20f, 600f, 300f,p)
        c.drawOval(600f, 20f, 420f, 300f,p)
        c.drawOval(420f, 20f, 220f, 300f,p)
        p.color = Color.rgb(78,51,51) //Cafe
        c.drawRect(1180f, 90f, 800f, 220f,p)
        //Arbol Izquierda
        p.color = Color.rgb(30,132,73) //Verde
        c.drawOval(400f, 1940f, 540f, 1700f,p)
        c.drawOval(530f, 1940f, 740f, 1700f,p)
        c.drawOval(730f, 1940f, 900f, 1700f,p)
        p.color = Color.rgb(78,51,51) //Cafe
        c.drawRect(1180f, 1940f, 800f, 1700f,p)
        when(auxiliar){
            0->{
                for(i in VectorCopos) {
                    i.moverCopos()
                    i.pintarCopo(c)
                }
            }
            1->{
                for(i in VectorCopos1) {
                    i.moverCopos()
                    i.pintarCopo(c)
                }
            }
            2->{
                for(i in VectorCopos2) {
                    i.moverCopos()
                    i.pintarCopo(c)
                }
            }
        }
        //Pintamos los copos
    }//OnDraw Fin

    override fun onTouchEvent(event: MotionEvent): Boolean {
       when(event.action) {
           MotionEvent.ACTION_DOWN -> {
               when(auxiliar){
                   0->{
                    fondo = VectorColores[auxiliar]
                       auxiliar=1
                   }
                   1->{
                       fondo = VectorColores[auxiliar]
                       auxiliar=2
                   }
                   2->{
                       fondo = VectorColores[auxiliar]
                       auxiliar=0
                   }
               }

           }
       }
        invalidate()
        return true
    }
}//Class