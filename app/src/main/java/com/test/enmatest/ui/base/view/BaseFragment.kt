package com.test.enmatest.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.test.enmatest.util.CommonUtil
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment(), IView {

    private var parentActivity: BaseActivity? = null
    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached(this.tag)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    /**
     * Hides progress indicator, this method is overridden throughout the app to hide custom loaders
     * and perform appropriate logic when hiding the progress indicator
     */
    override fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing!!) {
            progressDialog?.cancel()
        }
    }

    /**
     * Shows progress indicator, this method is overridden throughout the app to show custom loaders
     * and perform appropriate logic when showing the progress indicator
     */
    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this.context)
    }

    /**
     * @return the parent activity
     */
    fun getBaseActivity() = parentActivity

    /**
     * Performs Injection
     */
    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached(tag: String?)
        fun onFragmentDetached(tag: String)
    }

    /**
     * A method overridden in each fragment class, it has the setup/initialization of instances/data
     * important to that fragment
     */
    abstract fun setUp()
}