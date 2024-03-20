package br.com.dominando.android.basico

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.dominando.android.basico.ui.theme.BasicoTheme
import br.com.dominando.android.basico.ui.theme.StatesListActivity

class MainActivity : AppCompatActivity() {
    var state: String? = null
    lateinit var btnState: Button
    companion object {
        private const val REQUEST_STATE = 1
        private const val EXTRA_STATE = "estado"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL", "tela1::onCreate")
        setContentView(R.layout.activity_main)
        val buttonClick = View.OnClickListener {
            val intent = Intent(this, StatesListActivity::class.java)
            intent.putExtra(EXTRA_STATE, state)
            startActivityForResult(intent, REQUEST_STATE)
        }

        val btnState = findViewById<Button>(R.id.btnState)
        btnState.setOnClickListener(buttonClick)
       if(savedInstanceState != null) {
           state = savedInstanceState.getString(EXTRA_STATE)
           if(state != null) {
               btnState.text = state
           }
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && resultCode == REQUEST_STATE) {
            state = data?.getStringExtra(EXTRA_STATE)
            btnState.text = state
        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATE, state)
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