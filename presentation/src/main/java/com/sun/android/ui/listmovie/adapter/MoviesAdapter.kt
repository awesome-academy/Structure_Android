package com.sun.android.ui.listmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.android.data.model.Movie
import com.sun.android.databinding.ItemLayoutMovieBinding
import com.sun.android.utils.extension.loadImageCircleWithUrl
import com.sun.android.utils.extension.notNull
import com.sun.android.utils.recycler.OnItemRecyclerViewClickListener

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder?>() {

    private val movies = mutableListOf<Movie>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Movie>? = null

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
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Movie>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    fun updateData(movies: List<Movie>) {
        movies.notNull {
            this.movies.clear()
            this.movies.addAll(it)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        private val binding: ItemLayoutMovieBinding,
        itemClickListener: OnItemRecyclerViewClickListener<Movie>?
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var movieData: Movie? = null
        private var listener: OnItemRecyclerViewClickListener<Movie>? = null

        init {
            itemView.setOnClickListener(this)
            listener = itemClickListener
        }

        fun bindViewData(movie: Movie) {
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
