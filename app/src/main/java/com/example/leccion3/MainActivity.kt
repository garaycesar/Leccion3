package com.example.leccion3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.leccion3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var vista:ActivityMainBinding
    /*


Si la calificación está entre 90 y 100, la calificación letra es "A".
Si la calificación está entre 80 y 89, la calificación letra es "B".
Si la calificación está entre 70 y 79, la calificación letra es "C".
Si la calificación está entre 60 y 69, la calificación letra es "D".
Si la calificación es menor a 60, la calificación letra es "F".
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vista=ActivityMainBinding.inflate(layoutInflater)
        setContentView(vista.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        vista.calcular.setOnClickListener {
            calcularCalificacion()
        }
    }
    private fun calcularCalificacion(){
        if(! vista.nota.text.toString().isNullOrEmpty()){

            val nota=vista.nota.text.toString().toInt()
           var resultado= when(nota){
                in (90..100)->"A"
                in (80..89)->"B"
                in (70..79)->"C"
                in (60..69)->"D"
                in (0..60)->"F"

               else -> {"error"}
           }
            vista.resultado.setText("su calificacion es : $resultado")

        }else{
            Toast.makeText(this, "Ingresa el campo nota", Toast.LENGTH_SHORT).show()
        }
    }
}