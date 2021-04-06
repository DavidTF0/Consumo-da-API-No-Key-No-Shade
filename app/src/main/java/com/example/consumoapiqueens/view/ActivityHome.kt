package com.example.consumoapiqueens.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapiqueens.R
import com.example.consumoapiqueens.model.QueensItem
import com.example.consumoapiqueens.view.adapter.AdapterQueens
import com.example.consumoapiqueens.viewmodel.QueensViewModel

class ActivityHome : AppCompatActivity() {

    private var queens = mutableListOf<QueensItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recycler = findViewById<RecyclerView>(R.id.recycler_home)

        val viewModelQueens = ViewModelProviders.of(this).get(QueensViewModel::class.java)
        val adapterQueens = AdapterQueens(queens, this)
        recycler.adapter = adapterQueens
        val layoutManager = GridLayoutManager(this, 3)
        recycler.layoutManager = layoutManager

        viewModelQueens.getAllQueens()
        viewModelQueens.listMutableQueen.observe(this, Observer {
            it.let { itQueen -> queens.addAll(itQueen)}
            adapterQueens.notifyDataSetChanged()
        })
    }
}