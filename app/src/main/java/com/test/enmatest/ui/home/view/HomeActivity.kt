package com.test.enmatest.ui.home.view

import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseActivity
import com.test.enmatest.ui.home.interactor.IHomeInteractor
import com.test.enmatest.ui.home.presenter.IHomePresenter
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.enmatest.ui.home.adapter.HomeVPAdapter
import com.test.enmatest.util.gone
import com.test.enmatest.util.removeFragment
import com.test.enmatest.util.visible
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), IHomeView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: IHomePresenter<IHomeView, IHomeInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var homeVPAdapter: HomeVPAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.onAttach(this)
        presenter.setupBottomNavView()
    }

    override fun customizeBottomNavView() {
        bottomNavView.setTextVisibility(false)
        bottomNavView.enableAnimation(false)
        homeVPAdapter = HomeVPAdapter(supportFragmentManager, this)
        mainViewPager.adapter = homeVPAdapter
        mainViewPager.offscreenPageLimit = 4
        bottomNavView.setupWithViewPager(mainViewPager)
    }

    override fun showToolbarProgress() {
        toolbarProgress.visible()
        toolbarSearchIV.gone()
    }

    override fun hideToolbarProgress() {
        toolbarProgress.gone()
        toolbarSearchIV.visible()
    }

    override fun onFragmentAttached(tag: String?) {
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager.removeFragment(tag)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

}

