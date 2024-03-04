package br.com.dominando.android.basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import br.com.dominando.android.basico.models.Cliente

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val textMessage = findViewById<TextView>(R.id.textMensagem)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        textMessage.text = if(cliente != null) {
            "Nome:${cliente.nome} / Codigo: ${cliente.codigo}"
        }else {
            "Nome: $nome / idade: $idade"
        }

    }
}