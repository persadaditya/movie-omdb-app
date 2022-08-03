package com.persadaditya.app.ui.launch.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.persadaditya.app.BR
import com.persadaditya.app.R
import com.persadaditya.app.databinding.FragmentSplashBinding
import com.persadaditya.app.ui.base.BaseFragment
import com.persadaditya.app.utils.AppConstants
import javax.inject.Inject

class SplashFragment: BaseFragment<FragmentSplashBinding, SplashViewModel>(),SplashNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var splashViewModel: SplashViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun getViewModel(): SplashViewModel {
        splashViewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
        return splashViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.setNavigator(this)
        start()
    }

    private fun start() {
        Handler(Looper.getMainLooper()).postDelayed({
            openLogin()
        }, AppConstants.SPLASH_TIME)
    }

    private fun openLogin(){
        Navigation.findNavController(requireActivity(), R.id.launch_fragment)
            .navigate(SplashFragmentDirections.actionSplashFragmentToSearchFragment())
    }
}