package br.com.dominando.android.basico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
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

class MainActivity : ComponentActivity() {

    var names = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("NGVL", "tela1::onCreate")
        setContentView(R.layout.activity_main)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        val lstNames: ListView = findViewById<ListView>(R.id.lstNames)
        lstNames.adapter = adapter

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

    fun btnAddClick(view: View) {
        val edtName = findViewById<TextView>(R.id.edtName)
        names.add(edtName.text.toString())
        edtName.text = ""
        adapter?.notifyDataSetChanged()
    }
}

