package com.sun.android.ui

import com.sun.android.R
import com.sun.android.base.BaseActivity
import com.sun.android.databinding.ActivityMainBinding
import com.sun.android.ui.listmovie.MoviesFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val viewModel: MainViewModel by viewModel()

    override fun initialize() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(MoviesFragment::javaClass.name)
            .replace(R.id.layoutContainer, MoviesFragment())
            .commit()
    }
}
