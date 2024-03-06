package br.com.dominando.android.basico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL", "tela1::onCreate")
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTexto)
        val buttonClick = View.OnClickListener {
            it.setOnClickListener {
                val text = editText.text.toString()
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
            }
        }
        val buttonTelaClick = View.OnClickListener {
            it.setOnClickListener {
                val intent = Intent(this, Tela2Activity::class.java)
                intent.putExtra("nome", "Glauber")
                intent.putExtra("idade", 35)
                startActivity(intent)
            }
        }

        val buttonParcelClick = View.OnClickListener {
            val cliente = Cliente(codigo = 1, nome = "Bruce")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", Parcels.wrap(cliente))
            startActivity(intent)
        }

        val buttonSerializableClick = View.OnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("pessoa", Pessoa(nome = "Barion", idade = 35))
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.buttonToast)
        button.setOnClickListener(buttonClick)
        val buttonParcelable = findViewById<Button>(R.id.buttonParcel)
        val buttonSerializable = findViewById<Button>(R.id.buttonSerializable)
        buttonSerializable.setOnClickListener(buttonSerializableClick)
        buttonParcelable.setOnClickListener(buttonParcelClick)
        val buttonTela2 = findViewById<Button>(R.id.buttonTela2)
        buttonTela2.setOnClickListener(buttonTelaClick)
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