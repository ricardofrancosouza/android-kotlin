package br.com.dominando.android.basico

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import br.com.dominando.android.basico.models.Cliente
import br.com.dominando.android.basico.models.Pessoa
import org.parceler.Parcels

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL","Tela2::onCreate")
        setContentView(R.layout.activity_tela2)
        val textMessage = findViewById<TextView>(R.id.textMensagem)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = Parcels.unwrap<Cliente?>(intent.getParcelableExtra("cliente"))
        val pessoa = intent.getSerializableExtra("pessoa") as Pessoa?
        textMessage.text = if(pessoa != null){
            getString(R.string.tela2_texto1, pessoa.nome, pessoa.idade)
        } else if(cliente != null) {
            getString(R.string.tela2_texto2, cliente.nome, cliente.codigo)
            "Nome:${cliente.nome} / Codigo: ${cliente.codigo}"
        }else {
            getString(R.string.tela2_texto2, nome, idade)
        }

    }

    override fun onStart(){
        super.onStart()
        Log.i("NGVL", "tela2::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("NGVL","Tela2::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL","Tela2::onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("NGVL","Tela2::onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("NGVL","Tela2::onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL","Tela2::onDestroy")
    }
}