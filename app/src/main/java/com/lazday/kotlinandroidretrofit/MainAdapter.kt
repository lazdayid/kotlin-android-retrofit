package com.lazday.kotlinandroidretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_main.view.*
import kotlin.collections.ArrayList

class MainAdapter (var photos: ArrayList<MainModel>, val listener: OnAdapterListener):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
            LayoutInflater.from( parent.context ).inflate( R.layout.adapter_main,
                    parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.view.textView.text = photo.title
        holder.view.setOnClickListener { listener.onClick( photo ) }
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun setPhotos(photos: List<MainModel>){
        this.photos.clear()
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(photo: MainModel)
    }
}