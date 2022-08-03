package com.persadaditya.app.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.persadaditya.app.view.ProgressDialog
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<T:ViewDataBinding,V: BaseViewModel<*>>: Fragment() {

    private var mActivity : BaseActivity<*, *>? = null
    private var mRootView : View? = null
    private var mViewDataBinding: T? = null
    private var mViewModel: V? = null

    lateinit var dialog: Dialog

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<*, *>?
            mActivity = activity!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        dialog = ProgressDialog.progressDialog(requireContext())
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding?.root
        return mRootView
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.lifecycleOwner = this
        mViewDataBinding?.executePendingBindings()

        mViewModel?.loader?.observe(viewLifecycleOwner, Observer {
            if(it==null) return@Observer

            if(it){
                dialog.show()
            } else {
                dialog.hide()
            }

        })

        mViewModel?.error?.observe(viewLifecycleOwner, Observer {
            if(it==null) return@Observer

            Snackbar.make(getViewDataBinding().root, it.message, Snackbar.LENGTH_SHORT).show()
            mViewModel?.error?.value = null
        })
    }


    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    fun getBaseActivity(): BaseActivity<*, *> {
        return mActivity!!
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding!!
    }

    interface Callback {

        fun onFragmentDetached(tag: String):Boolean
    }


}