package com.example.notewithsharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.ImageView
import android.widget.TextView
import com.example.notewithsharedpref.model.Grid

class GridShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_show)
        val grid = intent.getParcelableExtra<Grid>("grid")!!

        val textView: TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)

        textView.text = getString(grid.text)
        imageView.setImageResource(grid.icon)
    }
}