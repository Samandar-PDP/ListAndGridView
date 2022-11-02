package com.example.notewithsharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import com.example.notewithsharedpref.adapter.NoteAdapter
import com.example.notewithsharedpref.manager.SharedPrefManager
import com.example.notewithsharedpref.model.Note
import com.example.notewithsharedpref.util.Time
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var fab: FloatingActionButton
    private lateinit var noteAdapter: NoteAdapter
    private val sharedPrefManager by lazy { SharedPrefManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        fab = findViewById(R.id.fab)


        supportActionBar?.hide()
        noteAdapter = NoteAdapter(this, sharedPrefManager.getNotes() ?: arrayListOf())
        listView.adapter = noteAdapter
        fab.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this).create()
        val view: View = LayoutInflater.from(this).inflate(R.layout.alert_dialog, null)
        alertDialog.setView(view)
        val editText: AppCompatEditText = view.findViewById(R.id.edit_alert)
        val btnCancel: MaterialButton = view.findViewById(R.id.btn_cancel)
        val btnSave: MaterialButton = view.findViewById(R.id.btn_save)

        btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }

        btnSave.setOnClickListener {
            val title = editText.text.toString().trim()
            val time = Time.timeStamp()
            if (title.isNotBlank()) {
                noteAdapter.saveNote(Note(title, time))
                sharedPrefManager.saveNote(noteAdapter.list)
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }
}