package com.example.consumoapiqueens.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapiqueens.R
import com.example.consumoapiqueens.model.QueensItem
import com.example.consumoapiqueens.view.ActivityDetail
import com.squareup.picasso.Picasso

class AdapterQueens(private val queensList: MutableList<QueensItem>, private val context: Context) : RecyclerView.Adapter<ViewHolderQueens>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderQueens {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolderQueens(view)
    }

    override fun getItemCount(): Int {
        return queensList.size
    }

    override fun onBindViewHolder(holder: ViewHolderQueens, position: Int) {
        val cardParticipant = holder.cardview
        val queens = queensList.elementAt(position)
        Picasso.get().load(queens.imageUrl).into(holder.image)
        holder.name.text = queens.name

        cardParticipant.setOnClickListener {
            val intentDetails = Intent(it.context, ActivityDetail::class.java)
            intentDetails.putExtra("PARTICIPANT_NAME", queens.name)
            intentDetails.putExtra("PARTICIPANT_IMG", queens.imageUrl)
            intentDetails.putExtra("PARTICIPANT_QUOTE", queens.quote)
            intentDetails.putExtra("PARTICIPANT_WINNER", queens.winner)
            intentDetails.putExtra("PARTICIPANT_MISS", queens.missCongeniality)
            it.context.startActivity(intentDetails)
        }

    }


}
