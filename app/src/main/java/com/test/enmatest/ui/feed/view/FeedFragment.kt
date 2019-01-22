package com.test.enmatest.ui.feed.view

import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseFragment
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.presenter.IFeedPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.test.enmatest.data.network.model.Post
import com.test.enmatest.ui.feed.adapter.FeedAdapter
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject
import androidx.recyclerview.widget.RecyclerView
import com.test.enmatest.ui.home.view.HomeActivity
import com.test.enmatest.util.AppConstants


class FeedFragment : BaseFragment(), IFeedView {

    @Inject
    internal lateinit var presenter: IFeedPresenter<IFeedView, IFeedInteractor>
    private lateinit var mFeedAdapter: FeedAdapter
    private val categoryId by lazy {
        arguments?.getString(EXTRA_CATEGORY_ID)
    }
    private var query: String = ""

    private val mFeedSkeleton: RecyclerViewSkeletonScreen by lazy {
        Skeleton.bind(feedRV)
            .adapter(mFeedAdapter)
            .load(R.layout.feed_item_skeleton)
            .show()
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "EXTRA_CATEGORY_ID"
        fun newInstance(categoryId: String? = null): FeedFragment {
            val args: Bundle = Bundle()
            args.putString(EXTRA_CATEGORY_ID, categoryId)
            val fragment = FeedFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        mFeedAdapter.removeCallback()
        presenter.onDetach()
        super.onDestroy()
    }

    override fun showProgress() {
        mFeedSkeleton.show()
    }

    override fun hideProgress() {
        mFeedSkeleton.hide()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showToolbarProgress() {
        if (activity is HomeActivity) {
            (activity as HomeActivity).showToolbarProgress()
        }
    }

    override fun hideToolbarProgress() {
        if (activity is HomeActivity) {
            (activity as HomeActivity).hideToolbarProgress()
        }
        swipeRefreshLayout.isRefreshing = false
    }


    override fun reflectPosts(posts: List<Post>?, isNewList: Boolean) {
        posts?.let {
            mFeedAdapter.addItems(it, isNewList)
        }
    }

    override fun setupFeedRV() {
        mFeedAdapter = FeedAdapter()
        mFeedAdapter.setCallback(presenter)
        feedRV.adapter = mFeedAdapter
        feedRV.layoutManager = LinearLayoutManager(context)
        feedRV.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        feedRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = recyclerView.layoutManager!!.childCount
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                val firstVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (!swipeRefreshLayout.isRefreshing) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - AppConstants.PAGINATION_MARGIN
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= AppConstants.PAGE_SIZE
                    ) {
                        presenter.getPosts(categoryId, query, false, false)
                    }
                }
            }
        })

        swipeRefreshLayout.setOnRefreshListener {
            refreshSearch()
        }
    }

    override fun setUp() {
        setupFeedRV()
        presenter.getPosts(categoryId, query, true, false)
    }

    override fun searchByQuery(query: String) {
        this.query = query
        refreshSearch()
    }

    private fun refreshSearch() {
        presenter.setLastPageNumber(0)
        presenter.getPosts(categoryId, query, true, true)
    }
}

