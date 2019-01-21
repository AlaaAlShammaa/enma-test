package com.test.enmatest.ui.categoryFeed.view

import android.content.Context
import android.content.Intent
import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.test.enmatest.ui.categoryFeed.interactor.ICategoryFeedInteractor
import com.test.enmatest.ui.categoryFeed.presenter.ICategoryFeedPresenter
import com.test.enmatest.ui.feed.view.FeedFragment
import com.test.enmatest.util.*
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_category_feed.*
import javax.inject.Inject

class CategoryFeedActivity : BaseActivity(), ICategoryFeedView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: ICategoryFeedPresenter<ICategoryFeedView, ICategoryFeedInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private val categoryId by lazy {
        intent.getStringExtra(EXTRA_CATEGORY_ID)
    }
    private val categoryName by lazy {
        intent.getStringExtra(EXTRA_CATEGORY_NAME)
    }
    companion object {
        const val EXTRA_CATEGORY_ID = "EXTRA_CATEGORY_ID"
        const val EXTRA_CATEGORY_NAME = "EXTRA_CATEGORY_NAME"
        fun getStartIntent(context: Context, categoryId: String, categoryName: String): Intent {
            val intent = Intent(context, CategoryFeedActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY_ID, categoryId)
            intent.putExtra(EXTRA_CATEGORY_NAME, categoryName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_feed)
        presenter.onAttach(this)
        toolbarTitle.text = categoryName
        supportFragmentManager.addFragment(
            R.id.fragmentFL,
            FeedFragment.newInstance(categoryId),
            FeedFragment::class.simpleName
        )
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

