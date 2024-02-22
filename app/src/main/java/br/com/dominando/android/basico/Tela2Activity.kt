package br.com.dominando.android.basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val textMessage = findViewById<TextView>(R.id.textMensagem)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        textMessage.text = "Nome: $nome / idade: $idade"
    }
}