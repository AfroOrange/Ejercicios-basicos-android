package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val programador = Programador()
        val datos = programador.getProgrammerData()

        Log.d("!:!:!:!", "Nombre: " ${datos.name}, "Edad: " ${datos.age} , "Lenguaje: "${datos.language} )
    }

    class Programador : ProgrammerInterface {

        private fun getName(): String {
            return "Manuel"
        }

        private fun getAge(): Int {
            return 25
        }

        private fun getLanguage(): String {
            return "Java"
        }
    }
}
interface ProgrammerInterface {
    fun getProgrammerData(): ProgrammerData
}

data class ProgrammerData (
    val name: String,
    val age: Int,
    val language: String
)