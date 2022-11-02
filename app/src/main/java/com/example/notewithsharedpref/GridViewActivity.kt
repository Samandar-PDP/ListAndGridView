package com.example.notewithsharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.core.os.bundleOf
import com.example.notewithsharedpref.adapter.GridAdapter
import com.example.notewithsharedpref.model.Grid
import com.example.notewithsharedpref.util.ObjectData
import com.example.notewithsharedpref.util.OnItemClickListener

class GridViewActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var gridAdapter: GridAdapter
    private lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        gridView = findViewById(R.id.gridView)
        gridAdapter = GridAdapter(this, ObjectData.grids, this)
        gridView.adapter = gridAdapter
    }

    override fun onClick(grid: Grid) {
        val intent = Intent(this, GridShowActivity::class.java)
        val bundle = bundleOf("grid" to grid)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}