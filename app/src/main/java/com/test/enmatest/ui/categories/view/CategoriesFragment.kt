package com.test.enmatest.ui.categories.view

import com.test.enmatest.R
import com.test.enmatest.ui.base.view.BaseFragment
import com.test.enmatest.ui.categories.interactor.ICategoriesInteractor
import com.test.enmatest.ui.categories.presenter.ICategoriesPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.test.enmatest.data.network.model.Category
import com.test.enmatest.ui.categories.adapter.CategoriesAdapter
import com.test.enmatest.ui.categoryFeed.view.CategoryFeedActivity
import kotlinx.android.synthetic.main.fragment_categories.*
import javax.inject.Inject

class CategoriesFragment : BaseFragment(), ICategoriesView {

    @Inject
    internal lateinit var presenter: ICategoriesPresenter<ICategoriesView, ICategoriesInteractor>

    private lateinit var mCategoriesAdapter: CategoriesAdapter

    private val mCategoriesSkeleton: RecyclerViewSkeletonScreen by lazy {
        Skeleton.bind(categoriesRV)
            .adapter(mCategoriesAdapter)
            .load(R.layout.category_item_skeleton)
            .show()
    }

    companion object {
        fun newInstance(): CategoriesFragment {
            val args: Bundle = Bundle()
            val fragment = CategoriesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

    override fun reflectCategories(data: List<Category>?) {
        data?.let {
            mCategoriesAdapter.addItems(it)
        }
    }

    override fun setupCategoriesRV() {
        mCategoriesAdapter = CategoriesAdapter()
        mCategoriesAdapter.setCallback(presenter)
        categoriesRV.adapter = mCategoriesAdapter
        categoriesRV.layoutManager = LinearLayoutManager(context)
        categoriesRV.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun showSkeletonUI() {
        mCategoriesSkeleton.show()
    }

    override fun hideSkeletonUI() {
        mCategoriesSkeleton.hide()
    }

    override fun launchCategoryFeed(category: Category) {
        activity?.let {
            startActivity(CategoryFeedActivity.getStartIntent(it, "${category.id}", category.name))
        }
    }

    override fun setUp() {
        presenter.initializeCategoriesRV()
        presenter.loadCategories()
    }

}

