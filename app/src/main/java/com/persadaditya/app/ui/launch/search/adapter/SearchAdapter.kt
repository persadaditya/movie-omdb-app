package com.persadaditya.app.ui.launch.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.persadaditya.app.R
import com.persadaditya.app.data.model.response.SearchItem
import com.persadaditya.app.databinding.ItemMovieBinding
import com.persadaditya.app.di.module.GlideApp

class SearchAdapter(private val listener: (SearchItem) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var item: List<SearchItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = item[position]
        holder.bindItem(data, listener)

    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: SearchItem, listener: (SearchItem) -> Unit) {
            with(itemView) {
                binding.model = item

                GlideApp.with(context)
                    .load(item.poster)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageMovie)

                setOnClickListener {
                    listener(item)
                }
            }
        }
    }

    fun setData(data: List<SearchItem>?) {
        if(data==null){
            this.item = listOf()
        } else {
            this.item = data
        }

        notifyItemRangeChanged(0, data?.size?:0)
    }
}