package com.example.miprimeraplicacionandorid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.miprimeraplicacionandorid.databinding.ActivityMainBinding
import com.example.miprimeraplicacionandorid.databinding.ActivitySecondBinding
import android.content.Intent as Intent

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    val miTag:String ="UdelP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id:Int = intent.getIntExtra("Id",0)
        val nombre:String? = intent.getStringExtra("Name")

        Toast.makeText(this@SecondActivity,"$id $nombre",Toast.LENGTH_SHORT).show()

        //abre un navegador url
        binding.btnUrl.setOnClickListener{

            var intent = Intent(Intent.ACTION_VIEW).apply{data= Uri.parse("http://www.google.com")}
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"No hay aplicacion asociada para abir esta peticion",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnMapa.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW).apply{data= Uri.parse("geo:19.28958619366017,-99.13938537622406?z=21 &q=19.28958619366017,-99.13938537622406")}
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"No hay aplicacion asociada para abir esta peticion",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnLlamada.setOnClickListener{
            var intent = Intent(Intent.ACTION_DIAL).apply{data= Uri.parse("tel:5620448876")}
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"No hay aplicacion asociada para abir esta peticion",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnEmail.setOnClickListener{

            val emails = arrayOf("edu_alr@hotmail.com")
            var intent = Intent(Intent.ACTION_SEND).apply{

                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL,emails)
                putExtra(Intent.EXTRA_SUBJECT,"Correo de Edu")
                putExtra(Intent.EXTRA_TEXT,"Hola este es un correo de prueba")
            }
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"No hay aplicacion asociada para abir esta peticion",Toast.LENGTH_SHORT).show()
            }
        }



        Log.d(miTag,"Estoy en onCreate - SECOND")
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag,"Estoy en onStart - SECOND ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag,"Estoy en onResume - SECOND ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag,"Estoy en onPause - SECOND")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag,"Estoy en onStop - SECOND ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag,"Estoy en onRestart - SECOND")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag,"Estoy en onDestroy - SECOND")
    }

}