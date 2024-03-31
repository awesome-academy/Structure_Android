package com.sun.android.ui.listmovie

import androidx.lifecycle.Observer
import com.sun.android.R
import com.sun.android.base.BaseFragment
import com.sun.android.data.model.Movie
import com.sun.android.databinding.MoviesFragmentBinding
import com.sun.android.ui.detail.DetailFragment
import com.sun.android.ui.listmovie.adapter.MoviesAdapter
import com.sun.android.utils.extension.addFragment
import com.sun.android.utils.extension.notNull
import com.sun.android.utils.recycler.OnItemRecyclerViewClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<MoviesFragmentBinding>(MoviesFragmentBinding::inflate),
    OnItemRecyclerViewClickListener<Movie> {

    private val mMovieAdapter: MoviesAdapter by lazy { MoviesAdapter() }

    override val viewModel: MoviesViewModel by viewModel()

    override fun initView() {
        binding.recyclerViewMovie.apply {
            adapter = mMovieAdapter
        }
        mMovieAdapter.registerItemRecyclerViewClickListener(this)
    }

    override fun initData() {
        viewModel.requestTopRateMovies()
    }

    override fun bindData() {
        viewModel.movies.observe(
            this,
            Observer { movies ->
                mMovieAdapter.updateData(movies)
            },
        )
    }

    override fun onItemClick(item: Movie?) {
        item.notNull {
            addFragment(R.id.layoutContainer, DetailFragment.newInstance(it.id), true)
        }
    }
}
