package com.example.notewithsharedpref.util

import com.example.notewithsharedpref.model.Grid

interface OnItemClickListener {
    fun onClick(grid: Grid)
}