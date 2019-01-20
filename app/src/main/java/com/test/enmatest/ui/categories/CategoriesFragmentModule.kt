package com.test.enmatest.ui.categories

import com.test.enmatest.ui.categories.interactor.CategoriesInteractorImpl
import com.test.enmatest.ui.categories.interactor.ICategoriesInteractor
import com.test.enmatest.ui.categories.presenter.CategoriesPresenterImpl
import com.test.enmatest.ui.categories.presenter.ICategoriesPresenter
import com.test.enmatest.ui.categories.view.ICategoriesView
import dagger.Module
import dagger.Provides

@Module
class CategoriesFragmentModule {

    @Provides
    internal fun provideCategoriesInteractor(CategoriesInteractorImpl: CategoriesInteractorImpl): ICategoriesInteractor = CategoriesInteractorImpl

    @Provides
    internal fun provideCategoriesPresenter(CategoriesPresenterImpl: CategoriesPresenterImpl<ICategoriesView, ICategoriesInteractor>)
            : ICategoriesPresenter<ICategoriesView, ICategoriesInteractor> = CategoriesPresenterImpl
}
