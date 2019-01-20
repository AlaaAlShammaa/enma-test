package com.test.enmatest.ui.categories

import com.test.enmatest.ui.categories.view.CategoriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CategoriesFragmentProvider {

    @ContributesAndroidInjector(modules = [CategoriesFragmentModule::class])
    internal abstract fun provideCategoriesFragmentFactory(): CategoriesFragment
}
