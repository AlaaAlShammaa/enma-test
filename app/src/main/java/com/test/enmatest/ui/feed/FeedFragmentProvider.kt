package com.test.enmatest.ui.feed

import com.test.enmatest.ui.feed.view.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FeedFragmentProvider {

    @ContributesAndroidInjector(modules = [FeedFragmentModule::class])
    internal abstract fun provideFeedFragmentFactory(): FeedFragment
}
