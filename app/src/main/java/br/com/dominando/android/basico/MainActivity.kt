package br.com.dominando.android.basico

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.dominando.android.basico.ui.theme.BasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        val button = findViewById<Button>(R.id.buttonToast)
        button.setOnClickListener(buttonClick)
        val buttonTela2 = findViewById<Button>(R.id.buttonTela2)
        buttonTela2.setOnClickListener(buttonTelaClick)
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