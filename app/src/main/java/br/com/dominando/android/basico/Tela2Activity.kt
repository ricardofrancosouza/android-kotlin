package br.com.dominando.android.basico

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import br.com.dominando.android.basico.models.Cliente
import br.com.dominando.android.basico.models.Pessoa
import org.parceler.Parcels

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}