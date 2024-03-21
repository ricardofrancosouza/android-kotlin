package br.com.dominando.android.basico

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.dominando.android.basico.ui.theme.BasicoTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL", "tela1::onCreate")
       val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.intent_action))
        listView.adapter = adapter
        listView.setOnItemClickListener {_, _, position,_ -> openIntentAPosition(position)}
    }

    private fun openIntentAPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?
        when(position){
            0 -> {
                //Abring uma URL
                uri = Uri.parse("http://www.nglauber.com.br")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            1 -> {
                //Realiza uma chamada
                uri = Uri.parse("tel:999887766")
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            2 -> {
                //Pesquisa uma posição do mapa
                //seu emulador/aparelho deve ter o Google Maps
                uri = Uri.parse("geo:0,0?q=Rua+Amelia, Recife")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            3 -> {
                //Abrindo o editor de SMS
                uri = Uri.parse("sms:12345")
                intent = Intent(Intent.ACTION_SEND, uri)
                    .putExtra("sms_body", "Corpo do SMS")
                openIntent(intent)
            }
            4 -> {
                //Compartilhar
                intent = Intent()
                    .setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Compartilhando via intent")
                    .setType("text/plain")
                openIntent(intent)
            }
            5 -> {
                //Alarme
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 0)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                    .putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(
                        Calendar.MONDAY,
                        Calendar.WEDNESDAY,
                        Calendar.FRIDAY
                    ))
                openIntent(intent)
            }
        }
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