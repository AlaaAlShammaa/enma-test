package com.test.enmatest.ui.searchFeed.view

import android.content.Context
import android.content.Intent
import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.test.enmatest.ui.searchFeed.interactor.ISearchFeedInteractor
import com.test.enmatest.ui.searchFeed.presenter.ISearchFeedPresenter
import com.test.enmatest.ui.feed.view.FeedFragment
import com.test.enmatest.util.*
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_search_feed.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class SearchFeedActivity : BaseActivity(), ISearchFeedView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: ISearchFeedPresenter<ISearchFeedView, ISearchFeedInteractor>
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
        fun getStartIntent(context: Context, categoryId: String?, categoryName: String): Intent {
            val intent = Intent(context, SearchFeedActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY_ID, categoryId)
            intent.putExtra(EXTRA_CATEGORY_NAME, categoryName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_feed)
        presenter.onAttach(this)
        toolbarTitle.text = categoryName
        supportFragmentManager.addFragment(
            R.id.fragmentFL,
            FeedFragment.newInstance(categoryId),
            FeedFragment::class.simpleName
        )
        val config = resources.configuration

        toolbarBackIV.scaleX =
                if (config.layoutDirection == View.LAYOUT_DIRECTION_RTL)
                    1f
                else
                    -1f
        toolbarBackIV.setOnClickListener {
            presenter.onBackClicked()
        }
        searchIV.setOnClickListener {
            presenter.onSearchClicked(searchET.text.toString())
        }
    }

    override fun showToolbarProgress() {
        toolbarProgress.visible()
    }

    override fun hideToolbarProgress() {
        toolbarProgress.gone()
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun searchByQuery(query: String) {
        if (query.isBlank()) {
            toast("Please enter a search query")
            return
        }
        val feedFragment = supportFragmentManager.findFragmentByTag(FeedFragment::class.simpleName) as FeedFragment?
        feedFragment?.let {
            if (it.isVisible) {
                it.searchByQuery(query)
            }
        }

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

