package com.example.idgs902temasbasicos.Ejemplo3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs902temasbasicos.R

private lateinit var edt1: EditText
private var num = 0
class Ejemplo3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo3)

        edt1 = findViewById<EditText>(R.id.ed1)
        num = (Math.random() * 100001).toInt()
        val cadena = num.toString()
        val notificacion = Toast.makeText(this, cadena, Toast.LENGTH_LONG)
        notificacion.show()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun controlar(view: View) {
        var valorIngresado: String = edt1.getText().toString()
        val valor = valorIngresado.toInt()
        if (valor == num) {
            val notificacion = Toast.makeText(this, "Muy bien recordaste el número mostrado", Toast.LENGTH_LONG)
            notificacion.show()
        } else {
            val notificacion = Toast.makeText(this, "Lo siento pero no era el número que mostré", Toast.LENGTH_LONG)
            notificacion.show()
        }
    }
}