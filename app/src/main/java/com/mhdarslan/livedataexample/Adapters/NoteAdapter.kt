package com.mhdarslan.livedataexample.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.livedataexample.Models.Note
import com.mhdarslan.livedataexample.R

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var list: List<Note> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }

    fun submitList(newList: List<Note>){
        this.list = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        val note = list.get(position)
        holder.txtNote.text = note.text
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtNote = itemView.findViewById<TextView>(R.id.txtNote)
    }
}