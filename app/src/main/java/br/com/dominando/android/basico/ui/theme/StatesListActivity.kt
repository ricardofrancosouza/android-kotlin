package br.com.dominando.android.basico.ui.theme

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import br.com.dominando.android.basico.R

class StatesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val statesList = resources.getStringArray(R.array.states)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, statesList)
        listView.adapter = listAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        val state = intent.getStringExtra(EXTRA_STATE)
        if(state != null){
            val position = statesList.indexOf(state)
            listView.setItemChecked(position, true)
        }
        listView.setOnItemClickListener { l, _, position, _ ->
            val result = l.getItemAtPosition(position) as String
            listView.setItemChecked(position, true)
            val it = Intent()
            it.putExtra(EXTRA_RESULT, result)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }

    companion object {
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "result"
    }
}