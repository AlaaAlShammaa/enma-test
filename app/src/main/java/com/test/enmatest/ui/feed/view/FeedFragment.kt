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

class FeedFragment : BaseFragment(), IFeedView {

    @Inject
    internal lateinit var presenter: IFeedPresenter<IFeedView, IFeedInteractor>
    private lateinit var mFeedAdapter: FeedAdapter
    private var query: String? = null

    private val mFeedSkeleton: RecyclerViewSkeletonScreen by lazy {
        Skeleton.bind(feedRV)
            .adapter(mFeedAdapter)
            .load(R.layout.feed_item_skeleton)
            .show()
    }

    companion object {
        fun newInstance(): FeedFragment {
            val args: Bundle = Bundle()
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
    }

    override fun reflectPosts(posts: List<Post>?) {
        posts?.let {
            mFeedAdapter.addItems(it)
        }
    }

    override fun setupFeedRV() {
        mFeedAdapter = FeedAdapter()
        mFeedAdapter.setCallback(presenter)
        feedRV.adapter = mFeedAdapter
        feedRV.layoutManager = LinearLayoutManager(context)
        feedRV.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun setUp() {
        setupFeedRV()
        presenter.getPosts(query)
    }

}

