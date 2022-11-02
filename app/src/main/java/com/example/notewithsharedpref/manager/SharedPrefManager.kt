package com.example.notewithsharedpref.manager

import android.content.Context
import android.content.SharedPreferences
import com.example.notewithsharedpref.model.Note
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SharedPrefManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("Pref", Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveNote(notes: ArrayList<Note>) {
        val editor = sharedPreferences.edit()
        editor.putString("notes", gson.toJson(notes))
        editor.apply()
    }

    fun getNotes(): ArrayList<Note>? {
        val json = sharedPreferences.getString("notes", null)
        val type: Type = object : TypeToken<ArrayList<Note>>() {}.type
        return gson.fromJson(json, type)
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}