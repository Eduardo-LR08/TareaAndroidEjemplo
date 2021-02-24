package com.example.miprimeraplicacionandorid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.miprimeraplicacionandorid.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val miTag:String ="UdelP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(miTag,"Estoy en onCreate - HOME")


        binding.btnAceptar.setOnClickListener{
            val i= Intent (this@MainActivity,SecondActivity::class.java).apply {
                putExtra("Id",23)
                putExtra("Name","Eduardo Rosas")
            }
            startActivity(i)
        }
        binding.btnToast.setOnClickListener{
            Toast.makeText(this@MainActivity, "Esto es un ejemplo de mensaje toast", Toast.LENGTH_SHORT).show()
        }
        binding.btnSnackbar.setOnClickListener{
            Snackbar.make(it,"Esto es un ejemplo de snackbar",Snackbar.LENGTH_LONG).show()
        }
        binding.btnDialog.setOnClickListener{
            miDialogo().show()
        }

        binding.fabMiBoton.setOnClickListener{
            Toast.makeText(this@MainActivity,"boton flotante",Toast.LENGTH_LONG).show()
        }

    }


    private fun miDialogo():AlertDialog{
        val miAlerta=AlertDialog.Builder(this@MainActivity)

        miAlerta.setTitle("Titulo del dialogo")
        miAlerta.setMessage("Mensaje del dialogo")
        miAlerta.setPositiveButton("si"){_,_ ->

            Toast.makeText(this@MainActivity,"clic en si",Toast.LENGTH_SHORT).show()
        }
        miAlerta.setNegativeButton("no"){_,_ ->

            Toast.makeText(this@MainActivity,"clic en no",Toast.LENGTH_SHORT).show()
        }
        return miAlerta.create()
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag,"Estoy en onStart - HOME ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag,"Estoy en onResume - HOME ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag,"Estoy en onPause - HOME")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag,"Estoy en onStop - HOME ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag,"Estoy en onRestart - HOME")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag,"Estoy en onDestroy - HOME")
    }


}