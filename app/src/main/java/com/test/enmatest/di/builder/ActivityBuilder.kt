package com.test.enmatest.di.builder

import com.test.enmatest.ui.categories.CategoriesFragmentProvider
import com.test.enmatest.ui.categoryFeed.CategoryFeedActivityModule
import com.test.enmatest.ui.categoryFeed.view.CategoryFeedActivity
import com.test.enmatest.ui.feed.FeedFragmentProvider
import com.test.enmatest.ui.home.HomeActivityModule
import com.test.enmatest.ui.home.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FeedFragmentProvider::class), (CategoriesFragmentProvider::class)])
    abstract fun bindHomeActivityModule(): HomeActivity
    @ContributesAndroidInjector(modules = [(CategoryFeedActivityModule::class), (FeedFragmentProvider::class)])
    abstract fun bindCategoryFeedActivityModule(): CategoryFeedActivity

}