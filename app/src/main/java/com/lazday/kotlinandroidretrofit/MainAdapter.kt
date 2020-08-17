package com.lazday.kotlinandroidretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_main.view.*
import kotlin.collections.ArrayList

class MainAdapter (val context: Context, var photos: ArrayList<MainModel>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
            LayoutInflater.from( parent.context ).inflate( R.layout.adapter_main,
                    parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        fun bind(photo: MainModel){
            view.textView.text = photo.title
        }
    }

    fun setPhotos(photos: List<MainModel>){
        this.photos.clear()
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }
}