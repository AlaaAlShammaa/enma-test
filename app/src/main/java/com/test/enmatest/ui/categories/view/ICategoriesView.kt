package com.test.enmatest.ui.categories.view

import com.test.enmatest.data.network.model.Category
import com.test.enmatest.ui.base.view.IView

interface ICategoriesView : IView {
    fun reflectCategories(data: List<Category>?)
    fun setupCategoriesRV()
    fun showSkeletonUI()
    fun hideSkeletonUI()
    fun launchCategoryFeed(category: Category)
}
