package com.test.enmatest.ui.categoryFeed


import com.test.enmatest.ui.categoryFeed.interactor.CategoryFeedInteractorImpl
import com.test.enmatest.ui.categoryFeed.interactor.ICategoryFeedInteractor
import com.test.enmatest.ui.categoryFeed.presenter.CategoryFeedPresenterImpl
import com.test.enmatest.ui.categoryFeed.presenter.ICategoryFeedPresenter
import com.test.enmatest.ui.categoryFeed.view.ICategoryFeedView
import dagger.Module
import dagger.Provides

@Module
class CategoryFeedActivityModule {

    @Provides
    internal fun provideCategoryFeedInteractor(categoryFeedInteractorImpl: CategoryFeedInteractorImpl): ICategoryFeedInteractor = categoryFeedInteractorImpl

    @Provides
    internal fun provideCategoryFeedPresenter(categoryFeedPresenterImpl: CategoryFeedPresenterImpl<ICategoryFeedView, ICategoryFeedInteractor>)
            : ICategoryFeedPresenter<ICategoryFeedView, ICategoryFeedInteractor> = categoryFeedPresenterImpl
}
