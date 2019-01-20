package com.test.enmatest.ui.feed.view

import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseFragment
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.presenter.IFeedPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

class FeedFragment : BaseFragment(), IFeedView {

    @Inject
    internal lateinit var presenter: IFeedPresenter<IFeedView, IFeedInteractor>
    companion object {
        fun newInstance(): FeedFragment {
            val args: Bundle = Bundle()
            val fragment = FeedFragment()
            fragment.arguments = args
            return fragment
        }
    }
 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun setUp() {

    }

}

