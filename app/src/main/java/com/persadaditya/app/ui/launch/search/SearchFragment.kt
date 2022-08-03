package com.persadaditya.app.ui.launch.search

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.persadaditya.app.BR
import com.persadaditya.app.R
import com.persadaditya.app.data.model.response.SearchItem
import com.persadaditya.app.databinding.FragmentSearchBinding
import com.persadaditya.app.ui.base.BaseFragment
import com.persadaditya.app.ui.launch.search.adapter.SearchAdapter
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(), SearchNavigator,
        (SearchItem) -> Unit {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SearchAdapter(this)
        getViewDataBinding().recyclerMovie.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        mViewModel.searchData.observe(viewLifecycleOwner, Observer {
            if(it==null){
                getViewDataBinding().tvNoData.visibility = View.VISIBLE
                adapter.setData(null)
                return@Observer
            }

            getViewDataBinding().tvNoData.visibility = View.GONE
            adapter.setData(it.search)

        })
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }

    override fun getViewModel(): SearchViewModel {
        mViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
        return  mViewModel
    }

    override fun activity(): Activity {
        return requireActivity()
    }

    override fun context(): Context {
        return requireContext()
    }


    ///on click item
    override fun invoke(item: SearchItem) {
        val action = SearchFragmentDirections.actionSearchFragmentToMovieFragment().setMovieId(item.imdbID)
        findNavController().navigate(action)
    }

}