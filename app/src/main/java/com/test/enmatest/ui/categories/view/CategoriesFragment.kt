package com.test.enmatest.ui.categories.view

import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseFragment
import com.test.enmatest.ui.categories.interactor.ICategoriesInteractor
import com.test.enmatest.ui.categories.presenter.ICategoriesPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

class CategoriesFragment : BaseFragment(), ICategoriesView {

    @Inject
    internal lateinit var presenter: ICategoriesPresenter<ICategoriesView, ICategoriesInteractor>
    companion object {
        fun newInstance(): CategoriesFragment {
            val args: Bundle = Bundle()
            val fragment = CategoriesFragment()
            fragment.arguments = args
            return fragment
        }
    }
 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
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

