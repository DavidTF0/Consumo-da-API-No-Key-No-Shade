package com.example.consumoapiqueens.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapiqueens.R

class ViewHolderQueens(view: View) : RecyclerView.ViewHolder(view) {

    val image = view.findViewById<ImageView>(R.id.imgcharacter_card)
    val name = view.findViewById<TextView>(R.id.txt_card)

}
