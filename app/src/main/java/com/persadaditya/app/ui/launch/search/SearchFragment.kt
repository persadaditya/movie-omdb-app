package com.persadaditya.app.ui.launch.search

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.persadaditya.app.BR
import com.persadaditya.app.R
import com.persadaditya.app.databinding.FragmentLoginBinding
import com.persadaditya.app.databinding.FragmentSearchBinding
import com.persadaditya.app.ui.base.BaseFragment
import com.persadaditya.app.ui.launch.login.LoginNavigator
import com.persadaditya.app.ui.launch.login.LoginViewModel
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(), SearchNavigator {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
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

}