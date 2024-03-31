package com.sun.android.ui.listmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.data.model.Movie
import com.sun.android.databinding.ItemLayoutMovieBinding
import com.sun.android.utils.extension.loadImageCircleWithUrl
import com.sun.android.utils.extension.notNull
import com.sun.android.utils.recycler.OnItemRecyclerViewClickListener

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder?>() {

    private val movies = mutableListOf<com.sun.data.model.Movie>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<com.sun.data.model.Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<com.sun.data.model.Movie>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    fun updateData(movies: List<com.sun.data.model.Movie>) {
        movies.notNull {
            this.movies.clear()
            this.movies.addAll(it)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        private val binding: ItemLayoutMovieBinding,
        itemClickListener: OnItemRecyclerViewClickListener<com.sun.data.model.Movie>?
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var movieData: com.sun.data.model.Movie? = null
        private var listener: OnItemRecyclerViewClickListener<com.sun.data.model.Movie>? = null

        init {
            itemView.setOnClickListener(this)
            listener = itemClickListener
        }

        fun bindViewData(movie: com.sun.data.model.Movie) {
            movie.let {
                binding.textViewTitle.text = it.title
                binding.textViewRatting.text = it.vote.toString()
                binding.textViewContent.text = it.originalTitle
                binding.imageMovie.loadImageCircleWithUrl(it.urlImage)
                movieData = it
            }
        }

        override fun onClick(view: View?) {
            listener?.onItemClick(movieData)
        }
    }
}
