package com.example.notewithsharedpref.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.notewithsharedpref.R
import com.example.notewithsharedpref.model.Grid
import com.example.notewithsharedpref.util.OnItemClickListener

class GridAdapter(
    private val context: Context,
    private val gridList: List<Grid>,
    private val onItemClickListener: OnItemClickListener
) : BaseAdapter() {
    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = gridList.size

    override fun getItem(p0: Int): Grid = gridList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = layoutInflater.inflate(R.layout.grid_item, p2, false)
        val myView: View = view.findViewById(R.id.view)
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        val grid = getItem(p0)
        myView.setBackgroundResource(grid.backView)
        textView.text = context.getString(grid.text)
        imageView.setImageResource(grid.icon)

        view.setOnClickListener {
            onItemClickListener.onClick(grid)
        }
        return view
    }
}