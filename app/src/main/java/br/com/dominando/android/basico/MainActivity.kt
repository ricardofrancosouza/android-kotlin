package br.com.dominando.android.basico

import android.content.Intent
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.dominando.android.basico.models.Cliente
import br.com.dominando.android.basico.models.Pessoa
import br.com.dominando.android.basico.ui.theme.BasicoTheme
import org.parceler.Parcels
import java.util.regex.Pattern

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL", "tela1::onCreate")
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Testando esse CEP 55555-4444"
        val pattern = Pattern.compile("\\d{5}([\\-]\\d{4})?")
        val scheme = "glauber://"
        Linkify.addLinks(textView, pattern, scheme)

    }

    override fun onStart(){
        super.onStart()
        Log.i("NGVL", "tela1::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("NGVL","Tela1::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL","Tela1::onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("NGVL","Tela1::onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("NGVL","Tela1::onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL","Tela1::onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicoTheme {
        Greeting("Android")
    }
}