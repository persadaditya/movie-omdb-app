package com.persadaditya.app.ui.launch.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val listener: (SearchItem) -> Unit)
    : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    
    private var item: List<SearchItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: SearchItem, listener: (SearchItem) -> Unit) {
            with(itemView) {
                //TODO Show Data
                
                setOnClickListener {
                    listener(item)
                }
            }
        }
    }
    
    fun setData(data: List<SearchItem>){
        this.item = data
        notifyDataSetChanged()
    }
}