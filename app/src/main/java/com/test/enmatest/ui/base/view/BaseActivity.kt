package com.test.enmatest.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.enmatest.util.CommonUtil
import dagger.android.AndroidInjection
import java.util.concurrent.atomic.AtomicBoolean


abstract class
BaseActivity : AppCompatActivity(), IView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null
    private var isRunningTest: AtomicBoolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        // before super.onCreate to avoid crashes on configuration changes (e.g. language, permissions...etc)
        performDI()
        super.onCreate(savedInstanceState)
    }

    /**
     * Hides progress indicator, this method is overridden throughout the app to hide custom loaders
     * and perform appropriate logic when hiding the progress indicator
     */
    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    /**
     * Shows progress indicator, this method is overridden throughout the app to show custom loaders
     * and perform appropriate logic when showing the progress indicator
     */
    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    /**
     * Performs injection
     */
    private fun performDI() = AndroidInjection.inject(this)

    public override fun onStart() {
        super.onStart()
    }

    public override fun onStop() {
        super.onStop()
    }


}