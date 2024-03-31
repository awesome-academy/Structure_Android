package com.sun.android.ui.detail

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.sun.android.base.BaseFragment
import com.sun.android.databinding.FragmentDetailBinding
import com.sun.android.utils.extension.goBackFragment
import com.sun.android.utils.extension.loadImageCircleWithUrl
import com.sun.android.utils.extension.loadImageWithUrl
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    override val viewModel: MovieDetailViewModel by viewModel()

    override fun initView() {
        binding.buttonImageBack.setOnClickListener { goBackFragment() }
    }

    override fun initData() {
        arguments?.run {
            val mMovieId = getInt(ARGUMENT_MOVIE_ID, -1)
            viewModel.requestMovieDetails(mMovieId)
        }
    }

    override fun bindData() {
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            binding.imageBackDrop.loadImageWithUrl(it.backDropImage)
            binding.imageMovie.loadImageCircleWithUrl(it.urlImage)
            binding.textTitle.text = it.title
            binding.textDescription.text = it.overView
            binding.textRatting.text = it.vote.toString()
            binding.textTotalReview.text = it.voteCount.toString()
        })
    }

    companion object {
        private const val ARGUMENT_MOVIE_ID = "ARGUMENT_MOVIE_ID"

        fun newInstance(movieId: Int) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_MOVIE_ID to movieId)
        }
    }
}
