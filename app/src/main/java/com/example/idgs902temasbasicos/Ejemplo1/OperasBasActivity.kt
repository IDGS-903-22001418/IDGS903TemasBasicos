package com.example.idgs902temasbasicos.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs902temasbasicos.R

class OperasBasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas_bas)

        val edtNumero1: EditText = findViewById<EditText>(R.id.edt1)
        val edtNumero2: EditText = findViewById<EditText>(R.id.edt2)
        val rgOperaciones: RadioGroup = findViewById(R.id.rgOperaciones)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val txtResultado: TextView = findViewById<TextView>(R.id.txtResultado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular.setOnClickListener {
            val num1 = edtNumero1.text.toString().toIntOrNull() ?: 0
            val num2 = edtNumero2.text.toString().toIntOrNull() ?: 0
            var resultado: Any = 0

            when (rgOperaciones.checkedRadioButtonId) {
                R.id.rbSumar -> resultado = sumar(num1, num2)
                R.id.rbRestar -> resultado = restar(num1, num2)
                R.id.rbMultiplicar -> resultado = multiplicar(num1, num2)
                R.id.rbDividir -> {
                    if (num2 == 0) {
                        resultado = "División no valida"
                    } else {
                        resultado = dividir(num1, num2)
                    }
                }
            }

            if (resultado is String) {
                txtResultado.text = resultado
            } else {
                txtResultado.text = "Resultado: $resultado"
            }
        }
    }

    fun sumar(n1: Int, n2: Int): Int {
        return n1 + n2
    }

    fun restar(n1: Int, n2: Int): Int {
        return n1 - n2
    }

    fun multiplicar(n1: Int, n2: Int): Int {
        return n1 * n2
    }

    fun dividir(n1: Int, n2: Int): Int {
        return n1 / n2
    }
}