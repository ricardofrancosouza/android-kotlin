package br.com.dominando.android.basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import br.com.dominando.android.basico.models.Cliente
import br.com.dominando.android.basico.models.Pessoa

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val textMessage = findViewById<TextView>(R.id.textMensagem)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        val pessoa = intent.getSerializableExtra("pessoa") as Pessoa
        textMessage.text = if(pessoa != null){
            "Nome: ${pessoa.nome} / Idade: ${pessoa.idade}"
        } else if(cliente != null) {
            "Nome:${cliente.nome} / Codigo: ${cliente.codigo}"
        }else {
            "Nome: $nome / idade: $idade"
        }

    }
}