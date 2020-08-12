package com.example.amandahinchman_dominguez.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapter(private val list: List<Gram>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val gram: Gram = list[position]
        holder.bind(gram)
    }

    override fun getItemCount(): Int = list.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var mImageView:ImageView?=null

    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mYearView = itemView.findViewById(R.id.list_description)
        mImageView=itemView.findViewById(R.id.list_image)
    }

    fun bind(movie: Gram) {
        mTitleView?.text = movie.title
        mYearView?.text = movie.desc.toString()
        Glide.with(itemView.context)
            .load(movie.Url)
            .into(mImageView)

    }


}