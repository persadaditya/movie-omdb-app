package com.persadaditya.app.ui.launch.movie

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.persadaditya.app.BR
import com.persadaditya.app.R
import com.persadaditya.app.databinding.FragmentMovieBinding
import com.persadaditya.app.databinding.FragmentSearchBinding
import com.persadaditya.app.di.module.GlideApp
import com.persadaditya.app.ui.base.BaseFragment
import com.persadaditya.app.ui.launch.search.SearchNavigator
import com.persadaditya.app.ui.launch.search.SearchViewModel
import javax.inject.Inject

class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>(), MovieNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mViewModel: MovieViewModel

    private val args: MovieFragmentArgs by navArgs<MovieFragmentArgs>()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_movie
    }

    override fun getViewModel(): MovieViewModel {
        mViewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        return  mViewModel
    }

    override fun activity(): Activity {
        return requireActivity()
    }

    override fun context(): Context {
        return requireContext()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().toolbar.setNavigationOnClickListener {
            activity().onBackPressed()
        }

        mViewModel.loadMovie(movieId = args.movieId)

        mViewModel.movie.observe(viewLifecycleOwner, Observer {
            if(it==null) return@Observer

            getViewDataBinding().model = it

            GlideApp.with(requireContext())
                .load(it.poster)
                .error(R.drawable.ic_launcher_background)
                .into(getViewDataBinding().imageMovie)

        })


    }


}