package com.example.notewithsharedpref.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.notewithsharedpref.R
import com.example.notewithsharedpref.model.Note

class NoteAdapter(
    private val context: Context,
    val list: ArrayList<Note>
) : BaseAdapter() {
    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = list.size

    override fun getItem(pos: Int): Any = list[pos]

    override fun getItemId(p0: Int): Long = p0.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(pos: Int, p1: View?, viewGroup: ViewGroup?): View {
        val view: View = layoutInflater.inflate(R.layout.item_layout, viewGroup, false)
        val title: TextView = view.findViewById(R.id.text_note)
        val time: TextView = view.findViewById(R.id.text_time)
        val note = getItem(pos) as Note
        title.text = note.title
        time.text = note.time
        return view
    }

    fun saveNote(note: Note) {
        list.add(note)
        notifyDataSetChanged()
    }
}