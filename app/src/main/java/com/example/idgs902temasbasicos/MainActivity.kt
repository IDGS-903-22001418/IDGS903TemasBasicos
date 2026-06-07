package com.example.idgs902temasbasicos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs902temasbasicos.Ejemplo1.OperasBasActivity
import com.example.idgs902temasbasicos.Ejemplo2.SaludoActivity
import com.example.idgs902temasbasicos.Ejemplo3.Ejemplo3Activity
import com.example.idgs902temasbasicos.Ejemplo4.Ejemplo4Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOperasBas = findViewById<Button>(R.id.btn1)
        btnOperasBas.setOnClickListener { navigateToOperaBas() }

        val btnSaludo = findViewById<Button>(R.id.btn2)
        btnSaludo.setOnClickListener { navigateToSaludo() }

        val btnEjemplo3 = findViewById<Button>(R.id.btn3)
        btnEjemplo3.setOnClickListener { navigateToEjemplo3() }

        val btnEjemplo4 = findViewById<Button>(R.id.btn4)
        btnEjemplo4.setOnClickListener { navigateToEjemplo4() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigateToOperaBas() {
        val intent = Intent(this, OperasBasActivity::class.java)
        startActivity(intent)
    }

    fun navigateToSaludo() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    fun navigateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }

    fun navigateToEjemplo4() {
        val intent = Intent(this, Ejemplo4Activity::class.java)
        startActivity(intent)
    }
}
