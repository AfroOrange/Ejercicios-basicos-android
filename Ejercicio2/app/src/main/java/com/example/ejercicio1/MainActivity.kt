package com.example.ejercicio1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Nuhacet Díaz Marrero

class MainActivity : AppCompatActivity() {

    object ownerData {
        const val NAME:String = "Julián"
    }

    object userData {
        const val NAME:String = "Jesús"
        const val AGE:Int = 32
        val HOBBIES: List<String> = listOf("comer", "cojones", "wiwi")
    }

    object etLog {
        const val TAG:String = "!:!:!TAG"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val person: Persona = Persona("Miguel", 23, listOf("Saltar", "correr", "comer"))
        securityBot(person)
    }

    private fun securityBot(person: Persona) {
        if (person.name == "Miguel") {
            when(person.age) {
                in 0 .. 17 -> Log.d(etLog.TAG, getString(R.string.mens_error_edad))
                in 65 ..100 -> Log.d(etLog.TAG, getString(R.string.mens_error_edad_elev))
                in 18 ..64 -> Log.d(etLog.TAG, getString(R.string.mens_access_autorized) + person.hobbies)
                else -> Log.d(etLog.TAG, getString(R.string.mens_wrong_char))
            }
        } else {
            Log.d(etLog.TAG, getString(R.string.mens_error_acceso)) // log d = debug
        }
    }
}

data class Persona(
    val name: String,
    val age: Int,
    val hobbies: List<String>
)